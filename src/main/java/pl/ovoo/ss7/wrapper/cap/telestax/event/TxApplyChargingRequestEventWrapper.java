/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.ApplyChargingRequest;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.ApplyChargingArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.ApplyChargingRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxApplyChargingArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2ApplyChargingArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap3.TxCap3ApplyChargingArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxApplyChargingRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxApplyChargingRequestEventWrapper extends TxEventWrapper implements ApplyChargingRequestEventWrapper {

    private final ApplyChargingRequest applyChargingRequest;

    public TxApplyChargingRequestEventWrapper(final ApplyChargingRequest applyChargingRequest, final ActivityContextInterface aci) {
        super(aci, applyChargingRequest);
        this.applyChargingRequest = applyChargingRequest;
    }

    @Override
    public ApplyChargingArgWrapper getArgument() throws Ss7WrapperException {
        final TxApplyChargingArgWrapper applyChargingArgWrapper;
        switch (getTxDialog().getApplicationContext()) {
            case CapV1_gsmSSF_to_gsmSCF:
                applyChargingArgWrapper = new TxApplyChargingArgWrapper();
                break;
            case CapV2_assistGsmSSF_to_gsmSCF:
            case CapV2_gsmSRF_to_gsmSCF:
            case CapV2_gsmSSF_to_gsmSCF:
                applyChargingArgWrapper = new TxCap2ApplyChargingArgWrapper();
                break;
            default:
                applyChargingArgWrapper = new TxCap3ApplyChargingArgWrapper();
        }

        applyChargingArgWrapper.setTxAchBillingChargingCharacteristics(applyChargingRequest.getAChBillingChargingCharacteristics());
        applyChargingArgWrapper.setTxPartyToCharge(applyChargingRequest.getPartyToCharge());
        return applyChargingArgWrapper;
    }
}
