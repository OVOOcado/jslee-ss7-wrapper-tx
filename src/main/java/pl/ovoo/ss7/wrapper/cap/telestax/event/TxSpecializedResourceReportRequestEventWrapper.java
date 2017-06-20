/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.SpecializedResourceReportRequest;
import pl.ovoo.ss7.wrapper.cap.args.SpecializedResourceReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.SpecializedResourceReportRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxSpecializedResourceReportArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxSpecializedResourceReportRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxSpecializedResourceReportRequestEventWrapper extends TxEventWrapper implements SpecializedResourceReportRequestEventWrapper {

    private final SpecializedResourceReportRequest specializedResourceReportRequest;

    public TxSpecializedResourceReportRequestEventWrapper(final SpecializedResourceReportRequest specializedResourceReportRequest, final ActivityContextInterface aci) {
        super(aci, specializedResourceReportRequest);
        this.specializedResourceReportRequest = specializedResourceReportRequest;
    }

    @Override
    public SpecializedResourceReportArgWrapper getArgument() {
        return new TxSpecializedResourceReportArgWrapper();
    }

}
