package pl.ovoo.ss7.wrapper.map.telestax.args;

import pl.ovoo.ss7.wrapper.map.args.SmRpUiWrapper;


/**
 * Created by karolsimka on 03.07.17.
 */
public class TxSmRpUiWrapper implements SmRpUiWrapper{

    private byte[] text;
    private String charset;
    private String originatingAddress;

    public TxSmRpUiWrapper() {super();}

    @Override
    public byte[] getText() {
        return this.text;
    }
    public void setText(byte[] text){
        this.text = text;
    }

    @Override
    public String getCharset() {
        return this.charset;
    }
    public void setCharset(String charset){
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
    public String toString() {
        return "TxSmRpUiWrapper [text=" + text + ", charset=" + charset + ", originatingAddress=" + originatingAddress + "]";
    }
}
