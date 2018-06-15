/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newcoin;

/**
 *
 * @author marti
 */
import java.security.*;
import java.util.ArrayList;

public class Transaction {
    
    public String transactionID; //this is the hash of the transaction
    public PublicKey sender; // senders public key
    public PublicKey reciepient; // Reciepients public key
    public float value; // Value of the transaction
    public byte[] signature; // the signature to prevent others to use your funds of your wallet
    
    public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
    public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();
    
    private static int sequence = 0; // count of how many transactions have been generated
    
    //contructor
    public Transaction(PublicKey from, PublicKey to, float value, ArrayList<TransactionInput> inputs) {
        this.sender = from;
        this.reciepient = to;
        this.value = value;
        this.inputs = inputs;
    }
    
    // this calculate the transaction hash
    private String calculateHash() {
        sequence++;  //increase the sequence to avoid transactions with same hash
        return StringUtil.applySha256(
                StringUtil.getStringFromKey(sender) +
                StringUtil.getStringFromKey(reciepient) +
                Float.toString(value) + sequence
        
        );
    }
    
}
