package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.FurnishChargingInformationRequest;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.FurnishChargingInformationArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.FurnishChargingInformationRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxFurnishChargingInformationArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2FurnishChargingInformationArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap3.TxCap3FurnishChargingInformationArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxFurnishChargingInformationRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxFurnishChargingInformationRequestEventWrapper extends TxEventWrapper implements FurnishChargingInformationRequestEventWrapper {

    private final FurnishChargingInformationRequest furnishChargingInformationRequest;

    public TxFurnishChargingInformationRequestEventWrapper(final FurnishChargingInformationRequest furnishChargingInformationRequest, final ActivityContextInterface aci) {
        super(aci, furnishChargingInformationRequest);
        this.furnishChargingInformationRequest = furnishChargingInformationRequest;
    }

    @Override
    public FurnishChargingInformationArgWrapper getArgument() throws Ss7WrapperException {
        final TxFurnishChargingInformationArgWrapper txFurnishChargingInformationArgWrapper;
        switch (getTxDialog().getApplicationContext()) {
            case CapV1_gsmSSF_to_gsmSCF:
                txFurnishChargingInformationArgWrapper= new TxFurnishChargingInformationArgWrapper();
                break;
            case CapV2_gsmSRF_to_gsmSCF:
            case CapV2_assistGsmSSF_to_gsmSCF:
            case CapV2_gsmSSF_to_gsmSCF:
                txFurnishChargingInformationArgWrapper = new TxCap2FurnishChargingInformationArgWrapper();
                break;
            case CapV3_cap3_sms:
            case CapV3_gprsSSF_gsmSCF:
            case CapV3_gsmSCF_gprsSSF:
            case CapV3_gsmSRF_gsmSCF:
            case CapV3_gsmSSF_scfAssistHandoff:
            case CapV3_gsmSSF_scfGeneric:
                txFurnishChargingInformationArgWrapper = new TxCap3FurnishChargingInformationArgWrapper();
                break;
            default:
                txFurnishChargingInformationArgWrapper = new TxCap3FurnishChargingInformationArgWrapper();
        }

        if (txFurnishChargingInformationArgWrapper instanceof TxCap2FurnishChargingInformationArgWrapper) {
            ((TxCap2FurnishChargingInformationArgWrapper) txFurnishChargingInformationArgWrapper).setTxFCIBCCCAMELsequence1(furnishChargingInformationRequest.getFCIBCCCAMELsequence1());
        }
        return txFurnishChargingInformationArgWrapper;
    }
}
