package pl.ovoo.ss7.wrapper.map.telestax.args;

import pl.ovoo.ss7.wrapper.map.args.MtForwardSMResponseWrapper;

/**
 * Created by karolsimka on 09.06.17.
 */
public class TxMtForwardShortMessageResponseWrapper implements MtForwardSMResponseWrapper{

    private String text;

    public TxMtForwardShortMessageResponseWrapper() {super();}

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text){
        this.text = text;
    }
}
