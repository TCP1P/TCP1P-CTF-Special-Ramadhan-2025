use anchor_lang::prelude::*;
use sha2::{Sha256, Digest};
declare_id!("CZY19xitzMjHWa25P3rzWsz3BLuBRpBnby2FQ7LTE4mQ");
#[program]
pub mod setup {
    use super::*;

    pub fn initialize(ctx: Context<Initialize>, password: String) -> Result<()> {
        let vault = &mut ctx.accounts.vault;
        let mut hasher = Sha256::new();
        hasher.update(password.as_bytes());
        let password_hash = format!("{:x}", hasher.finalize());
        vault.password_hash = password_hash;
        vault.solved = false;
        vault.owner = ctx.accounts.user.key();
        Ok(())
    }

    pub fn attempt_solve(ctx: Context<Solve>, password: String) -> Result<()> {
        let vault = &mut ctx.accounts.vault;
        
        let mut hasher = Sha256::new();
        hasher.update(password.as_bytes());
        let result = format!("{:x}", hasher.finalize());

        require!(result == ctx.accounts.attempt_deposit.password_hash, CustomError::IncorrectPassword);
        vault.solved = true;
       
        Ok(())
    }

    pub fn is_solved(ctx: Context<IsSolved>) -> Result<bool> {
        let vault = &ctx.accounts.vault;
        Ok(vault.solved)
    }
}

#[error_code]
pub enum CustomError {
    #[msg("Incorrect password")]
    IncorrectPassword,
    #[msg("Incorrect owner")]
    IncorrectOwner,
}

#[derive(Accounts)]
pub struct Initialize<'info> {
    #[account(
        init,
        payer = user,
        space = 8 + VaultState::INIT_SPACE,
    )]
    pub vault: Account<'info, VaultState>,
    #[account(mut)]
    pub user: Signer<'info>,
    pub system_program: Program<'info, System>,
}

#[derive(Accounts)]
pub struct Solve<'info> {
    #[account(mut)]
    pub vault: Account<'info, VaultState>,
    #[account(mut)]
    pub attempt_deposit: Account<'info, VaultState>,
    #[account(mut)]
    pub user: Signer<'info>,
}

#[derive(Accounts)]
pub struct IsSolved<'info> {
    pub vault: Account<'info, VaultState>,
}

#[account]
#[derive(InitSpace)]
pub struct VaultState {
    pub owner: Pubkey,
    #[max_len(64)]
    pub password_hash: String,
    pub solved: bool,
}