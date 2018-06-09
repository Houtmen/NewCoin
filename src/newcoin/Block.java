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
import java.util.Date;

public class Block {
    
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;
    
    //Block Constructor.
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }
    public String calculateHash() {
        String calculatedHash = StringUtil.applySha256(
                    previousHash +
                    Long.toString(timeStamp) +
                    data        
        );
    return calculatedHash;
    }
    
}
