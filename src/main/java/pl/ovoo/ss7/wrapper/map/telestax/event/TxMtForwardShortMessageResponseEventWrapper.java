package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.protocols.ss7.map.api.service.sms.MtForwardShortMessageResponse;
import pl.ovoo.ss7.wrapper.map.args.MtForwardSMResponseWrapper;
import pl.ovoo.ss7.wrapper.map.event.MtForwardSMResponseEventWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMtForwardShortMessageResponseWrapper;
import sun.nio.cs.StandardCharsets;

import javax.slee.ActivityContextInterface;

/**
 * Created by karolsimka on 09.06.17.
 */
public class TxMtForwardShortMessageResponseEventWrapper extends TxMapEventWrapper implements MtForwardSMResponseEventWrapper {

    private final MtForwardShortMessageResponse mtForwardShortMessageResponse;

    public TxMtForwardShortMessageResponseEventWrapper(final MtForwardShortMessageResponse mtForwardShortMessageResponse, final ActivityContextInterface aci) {
        super(aci);
        this.mtForwardShortMessageResponse = mtForwardShortMessageResponse;
    }

    @Override
    public MtForwardSMResponseWrapper getArgument() {
        TxMtForwardShortMessageResponseWrapper sri = new TxMtForwardShortMessageResponseWrapper();

        String text = new String(mtForwardShortMessageResponse.getSM_RP_UI().getData(),mtForwardShortMessageResponse.getSM_RP_UI().getGsm8Charset());
        sri.setText(text);
        return sri;
    }

    @Override
    public long getInvokeId() {
        return mtForwardShortMessageResponse.getInvokeId();
    }
}
