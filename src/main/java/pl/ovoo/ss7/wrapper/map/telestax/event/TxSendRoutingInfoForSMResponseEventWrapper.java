package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.protocols.ss7.map.api.service.callhandling.SendRoutingInformationResponse;
import org.mobicents.protocols.ss7.map.api.service.sms.SendRoutingInfoForSMResponse;
import org.mobicents.protocols.ss7.map.primitives.ISDNAddressStringImpl;
import pl.ovoo.ss7.wrapper.common.telestax.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoForSMResponseWrapper;
import pl.ovoo.ss7.wrapper.map.event.SendRoutingInfoForSMResponseEventWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSendRoutingInfoForSMResponseWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSendRoutingInfoRequestArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * Created by karolsimka on 07.06.17.
 */
public class TxSendRoutingInfoForSMResponseEventWrapper extends TxMapEventWrapper implements SendRoutingInfoForSMResponseEventWrapper {

    private final SendRoutingInfoForSMResponse sendRoutingInfoForSMResponse;

    public TxSendRoutingInfoForSMResponseEventWrapper(final SendRoutingInfoForSMResponse sendRoutingInfoForSMResponse, final ActivityContextInterface aci) {
        super(aci);
        this.sendRoutingInfoForSMResponse = sendRoutingInfoForSMResponse;
    }

    @Override
    public SendRoutingInfoForSMResponseWrapper getArgument() {
        TxSendRoutingInfoForSMResponseWrapper sri = new TxSendRoutingInfoForSMResponseWrapper();
        sri.setImsi(new TxIMSIAddressWrapper(sendRoutingInfoForSMResponse.getIMSI()));
        sri.setMscAddress(new TxISDNAddressStringWrapperImpl(sendRoutingInfoForSMResponse.getLocationInfoWithLMSI().getNetworkNodeNumber()));
        return sri;
    }

    @Override
    public long getInvokeId() {
        return sendRoutingInfoForSMResponse.getInvokeId();
    }
}
