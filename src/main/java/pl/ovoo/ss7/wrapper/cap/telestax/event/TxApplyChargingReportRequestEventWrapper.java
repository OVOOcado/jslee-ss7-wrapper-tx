/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.ApplyChargingReportRequest;
import pl.ovoo.ss7.wrapper.cap.args.ApplyChargingReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.ApplyChargingReportRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxApplyChargingReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2ApplyChargingReportArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxApplyChargingReportRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxApplyChargingReportRequestEventWrapper extends TxEventWrapper implements ApplyChargingReportRequestEventWrapper {

    private final ApplyChargingReportRequest applyChargingReportRequestEvent;

    public TxApplyChargingReportRequestEventWrapper(final ApplyChargingReportRequest applyChargingReportRequestEvent, final ActivityContextInterface aci) {
        super(aci, applyChargingReportRequestEvent);
        this.applyChargingReportRequestEvent = applyChargingReportRequestEvent;
    }

    @Override
    public ApplyChargingReportArgWrapper getArgument() {
        final TxApplyChargingReportArgWrapper txApplyChargingReportArgWrapper;
        switch (getTxDialog().getApplicationContext()) {
            case CapV1_gsmSSF_to_gsmSCF:
                txApplyChargingReportArgWrapper = new  TxApplyChargingReportArgWrapper();
                break;
            default:
                txApplyChargingReportArgWrapper = new TxCap2ApplyChargingReportArgWrapper();
        }
        if (txApplyChargingReportArgWrapper instanceof TxCap2ApplyChargingReportArgWrapper) {
            ((TxCap2ApplyChargingReportArgWrapper) txApplyChargingReportArgWrapper).setTxTimeDurationChargingResult(applyChargingReportRequestEvent.getTimeDurationChargingResult());
        }
        return txApplyChargingReportArgWrapper;
    }
}
