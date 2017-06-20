package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.protocols.ss7.map.api.service.callhandling.SendRoutingInformationResponse;
import pl.ovoo.ss7.wrapper.common.telestax.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxRoutingInfoWrapper;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoResponseWrapper;
import pl.ovoo.ss7.wrapper.map.event.SendRoutingInfoResponseEventWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSendRoutingInfoResponseWrapper;

import javax.slee.ActivityContextInterface;

/**
 * Created by karolsimka on 07.06.17.
 */
public class TxSendRoutingInfoResponseEventWrapper extends TxMapEventWrapper implements SendRoutingInfoResponseEventWrapper{

    private final SendRoutingInformationResponse sendRoutingInformationResponse;

    public TxSendRoutingInfoResponseEventWrapper(final SendRoutingInformationResponse sendRoutingInformationResponse, final ActivityContextInterface aci) {
        super(aci);
        this.sendRoutingInformationResponse = sendRoutingInformationResponse;
    }

    @Override
    public SendRoutingInfoResponseWrapper getArgument() {
        TxSendRoutingInfoResponseWrapper sri = new TxSendRoutingInfoResponseWrapper();
        sri.setImsi(new TxIMSIAddressWrapper(sendRoutingInformationResponse.getIMSI()));
        sri.setRoutingInfo(new TxRoutingInfoWrapper(sendRoutingInformationResponse.getRoutingInfo2()));
        return sri;
    }

    @Override
    public long getInvokeId() {
        return sendRoutingInformationResponse.getInvokeId();
    }
}
