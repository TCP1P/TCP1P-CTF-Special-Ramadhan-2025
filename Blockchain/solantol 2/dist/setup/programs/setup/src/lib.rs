use anchor_lang::prelude::*;

declare_id!("CZY19xitzMjHWa25P3rzWsz3BLuBRpBnby2FQ7LTE4mQ");

#[program]
pub mod setup {
    use super::*;

    pub fn initialize(ctx: Context<Initialize>, password: String) -> Result<()> {
        let vault = &mut ctx.accounts.vault;
        vault.password = password;
        vault.solved = false;
        vault.owner = ctx.accounts.user.key();
        Ok(())
    }

    pub fn solve(ctx: Context<Solve>, password: String) -> Result<()> {
        let vault = &mut ctx.accounts.vault;
        
        if password == vault.password {
            vault.solved = true;
        }
        
        Ok(())
    }

    pub fn is_solved(ctx: Context<IsSolved>) -> Result<bool> {
        let vault = &ctx.accounts.vault;
        Ok(vault.solved)
    }
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
}

#[derive(Accounts)]
pub struct IsSolved<'info> {
    pub vault: Account<'info, VaultState>,
}

#[account]
#[derive(InitSpace)]
pub struct VaultState {
    pub owner: Pubkey,
    #[max_len(100)]
    pub password: String,
    pub solved: bool,
}