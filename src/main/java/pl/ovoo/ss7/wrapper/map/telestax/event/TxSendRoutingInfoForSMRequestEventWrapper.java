package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.protocols.ss7.map.api.service.sms.SendRoutingInfoForSMRequest;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoForSMRequestArgWrapper;
import pl.ovoo.ss7.wrapper.map.event.SendRoutingInfoForSMRequestEventWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSendRoutingInfoForSMRequestArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * Created by karolsimka on 07.06.17.
 */
public class TxSendRoutingInfoForSMRequestEventWrapper extends TxMapEventWrapper implements SendRoutingInfoForSMRequestEventWrapper {

    private final SendRoutingInfoForSMRequest sendRoutingInfoForSMRequest;

    public TxSendRoutingInfoForSMRequestEventWrapper(final SendRoutingInfoForSMRequest sendRoutingInfoForSMRequest, final ActivityContextInterface aci) {
        super(aci);
        this.sendRoutingInfoForSMRequest = sendRoutingInfoForSMRequest;
    }

    @Override
    public SendRoutingInfoForSMRequestArgWrapper getArgument() {
        TxSendRoutingInfoForSMRequestArgWrapper sri = new TxSendRoutingInfoForSMRequestArgWrapper();
        sri.setMsisdn(new TxISDNAddressStringWrapperImpl(sendRoutingInfoForSMRequest.getMsisdn()));
        return sri;
    }

    @Override
    public long getInvokeId() {
        return sendRoutingInfoForSMRequest.getInvokeId();
    }
}
