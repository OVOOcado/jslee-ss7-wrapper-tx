package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.service.sms.MtForwardShortMessageRequest;

import pl.ovoo.ss7.wrapper.common.telestax.TxAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.common.telestax.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.common.telestax.TxRoutingInfoWrapper;
import pl.ovoo.ss7.wrapper.map.args.MtForwardShortMessageRequestWrapper;
import pl.ovoo.ss7.wrapper.map.event.MtForwardShortMessageRequestEventWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMtForwardShortMessageRequestArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * Created by karolsimka on 08.06.17.
 */
public class TxMtForwardShortMessageRequestEventWrapper extends TxMapEventWrapper implements MtForwardShortMessageRequestEventWrapper {

    private final MtForwardShortMessageRequest mtForwardShortMessageRequest;

    public TxMtForwardShortMessageRequestEventWrapper(final MtForwardShortMessageRequest mtForwardShortMessageRequest, final ActivityContextInterface aci) {
        super(aci);
        this.mtForwardShortMessageRequest = mtForwardShortMessageRequest;
    }

    @Override
    public MtForwardShortMessageRequestWrapper getArgument() {
        TxMtForwardShortMessageRequestArgWrapper txMtForwardShortMessageRequestArgWrapper = new TxMtForwardShortMessageRequestArgWrapper();
        txMtForwardShortMessageRequestArgWrapper.setImsi(new TxIMSIAddressWrapper(mtForwardShortMessageRequest.getSM_RP_DA().getIMSI()));
        TxAddressStringWrapperImpl txServiceCentreAddressOA = new TxAddressStringWrapperImpl(mtForwardShortMessageRequest.getSM_RP_OA().getServiceCentreAddressOA());
        txMtForwardShortMessageRequestArgWrapper.setServiceCentreAddressOA(txServiceCentreAddressOA);
        txMtForwardShortMessageRequestArgWrapper.setText(mtForwardShortMessageRequest.getSM_RP_UI().getData().toString());
        return txMtForwardShortMessageRequestArgWrapper;
    }

    @Override
    public long getInvokeId() {
        return mtForwardShortMessageRequest.getInvokeId();
    }
}
