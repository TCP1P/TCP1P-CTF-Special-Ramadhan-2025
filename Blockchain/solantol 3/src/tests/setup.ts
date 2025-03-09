import * as anchor from "@coral-xyz/anchor";
import { Program } from "@coral-xyz/anchor";
import { Setup } from "../target/types/setup";
import { Keypair } from "@solana/web3.js";

const solvedAccount = process.env.solvedAccount;

describe("setup", () => {
  const provider = anchor.AnchorProvider.env()
  const vault =  Keypair.fromSecretKey(Uint8Array.from(JSON.parse(solvedAccount)))
  anchor.setProvider(provider);

  const program = anchor.workspace.Setup as Program<Setup>;
  
  it("Should initialize vault", async () => {
    const randomString = require('crypto').randomBytes(128).toString('hex');
    const password = randomString;

    const tx = await program.methods
      .initialize(password)
      .accounts({
        vault: vault.publicKey,
        user: provider.wallet.publicKey,
      })
      .signers([vault])
      .rpc();
    const signatureResult = await provider.connection.confirmTransaction(tx);
    console.log(JSON.stringify({"message": signatureResult}));
  });
}); 