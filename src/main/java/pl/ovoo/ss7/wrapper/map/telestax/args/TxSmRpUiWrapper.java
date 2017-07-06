package pl.ovoo.ss7.wrapper.map.telestax.args;

import java.nio.charset.Charset;

import pl.ovoo.ss7.wrapper.map.args.CharsetWrapper;
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
    public String toString() {
        return "TxSmRpUiWrapper [text=" + text + ", charset=" + charset + ", originatingAddress=" + originatingAddress + "]";
    }
}
