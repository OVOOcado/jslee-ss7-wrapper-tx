package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.protocols.ss7.map.api.service.sms.ReportSMDeliveryStatusRequest;
import pl.ovoo.ss7.wrapper.common.args.SmDeliveryOutcome;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.event.SmsDeliverTpduEventWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSmsDeliverTpduWrapper;

import javax.slee.ActivityContextInterface;

/**
 * Created by karolsimka on 12.06.17.
 */
public class TxSmsDeliverTpduEventWrapper extends TxMapEventWrapper implements SmsDeliverTpduEventWrapper{

    private final ReportSMDeliveryStatusRequest reportSMDeliveryStatusRequest;

    public TxSmsDeliverTpduEventWrapper(final ReportSMDeliveryStatusRequest reportSMDeliveryStatusRequest, final ActivityContextInterface aci) {
        super(aci);
        this.reportSMDeliveryStatusRequest = reportSMDeliveryStatusRequest;
    }

    @Override
    public TxSmsDeliverTpduWrapper getArgument() {
        TxSmsDeliverTpduWrapper smd = new TxSmsDeliverTpduWrapper();
        smd.setMsisdn(new TxISDNAddressStringWrapperImpl(reportSMDeliveryStatusRequest.getMsisdn()));
        smd.setSmDeliveryOutcome(SmDeliveryOutcome.valueOf(reportSMDeliveryStatusRequest.getSMDeliveryOutcome().getCode()));
        return smd;
    }

    @Override
    public long getInvokeId() {
        return reportSMDeliveryStatusRequest.getInvokeId();
    }

}
