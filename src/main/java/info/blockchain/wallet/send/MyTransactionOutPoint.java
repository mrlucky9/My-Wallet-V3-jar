package info.blockchain.wallet.send;

import java.math.BigInteger;

import org.bitcoinj.core.Coin;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.ProtocolException;
import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.core.TransactionOutPoint;
import org.bitcoinj.core.TransactionOutput;
import org.bitcoinj.params.MainNetParams;

public class MyTransactionOutPoint extends TransactionOutPoint {

	private static final long serialVersionUID = 1L;
	private byte[] scriptBytes;	
	private int txOutputN;
	private Sha256Hash txHash;
	private BigInteger value;
	private int confirmations;
	
	public MyTransactionOutPoint(Sha256Hash txHash, int txOutputN, BigInteger value, byte[] scriptBytes) throws ProtocolException {
		super(MainNetParams.get(), txOutputN, new Sha256Hash(txHash.getBytes()));
		this.scriptBytes = scriptBytes;
		this.value = value;
		this.txOutputN = txOutputN;
		this.txHash = txHash;
	}

	public int getConfirmations() {
		return confirmations;
	}

	public byte[] getScriptBytes() {
		return scriptBytes;
	}

	public int getTxOutputN() {
		return txOutputN;
	}

	public Sha256Hash getTxHash() {
		return txHash;
	}

	public BigInteger getValue() {
		return value;
	}

	public void setConfirmations(int confirmations) {
		this.confirmations = confirmations;
	}

	@Override
	public TransactionOutput getConnectedOutput() {		       
		return new TransactionOutput(params, null, Coin.valueOf(value.longValue()), scriptBytes);
	}

	//@Override
	public byte[] getConnectedPubKeyScript() {
		return scriptBytes;
	}
}