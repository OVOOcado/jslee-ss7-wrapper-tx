package pl.ovoo.ss7.wrapper.map.telestax.args;

import java.util.Arrays;

import pl.ovoo.ss7.wrapper.map.args.DataCodingWrapper;
import pl.ovoo.ss7.wrapper.map.args.SmRpUiWrapper;


/**
 * Created by karolsimka on 03.07.17.
 */
public class TxSmRpUiWrapper implements SmRpUiWrapper{

    private String text;
    private byte[] data;
    private DataCodingWrapper charset;
    private String originatingAddress;
    private boolean moreMessagesToSend;
    private boolean isConcatened;
    private int messageRef;
    private int segmCnt;
    private int segmNum;

    public TxSmRpUiWrapper() {super();}

    @Override
    public String getText() {
        return this.text;
    }
    public void setText(String text){
        this.text = text;
    }

    @Override
    public byte[] getData() {
        return this.data;
    }
    public void setData(byte[] data){
        this.data = data;
    }

    @Override
    public DataCodingWrapper getCharset() {
        return this.charset;
    }
    public void setCharset(DataCodingWrapper charset){
        this.charset = charset;
    }

    @Override
    public String getOriginatingAddress() {
        return this.originatingAddress;
    }
    public void setOriginatingAddress(String originatingAddress){
        this.originatingAddress = originatingAddress;
    }

    @Override
    public boolean getMoreMessagesToSend(){
    	return this.moreMessagesToSend;
    }
    public void setMoreMessagesToSend(boolean moreMessagesToSend){
        this.moreMessagesToSend = moreMessagesToSend;
    }

    @Override
    public boolean getIsConcatened() {
		return isConcatened;
	}

	public void setIsConcatened(boolean isConcatened) {
		this.isConcatened = isConcatened;
	}

	@Override
    public int getMessageRef() {
		return messageRef;
	}

	public void setMessageRef(int messageRef) {
		this.messageRef = messageRef;
	}

	@Override
    public int getSegmCnt() {
		return segmCnt;
	}

	public void setSegmCnt(int segmCnt) {
		this.segmCnt = segmCnt;
	}

	@Override
    public int getSegmNum() {
		return segmNum;
	}

	public void setSegmNum(int segmNum) {
		this.segmNum = segmNum;
	}

	@Override
	public String toString() {
		return "TxSmRpUiWrapper [text=" + text + ", data=" + Arrays.toString(data) + ", charset=" + charset
				+ ", originatingAddress=" + originatingAddress + ", moreMessagesToSend=" + moreMessagesToSend
				+ ", isConcatened=" + isConcatened + ", messageRef=" + messageRef + ", segmCnt=" + segmCnt
				+ ", segmNum=" + segmNum + "]";
	}
}
