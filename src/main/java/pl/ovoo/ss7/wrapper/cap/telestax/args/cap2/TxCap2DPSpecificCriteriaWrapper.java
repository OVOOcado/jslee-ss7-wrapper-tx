/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.DpSpecificCriteria;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2DPSpecificCriteriaWrapper;

/**
 * TxCap2DPSpecificCriteriaWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2DPSpecificCriteriaWrapper implements Cap2DPSpecificCriteriaWrapper {

    private final DpSpecificCriteria dpSpecificCriteria;

    public TxCap2DPSpecificCriteriaWrapper(final DpSpecificCriteria dpSpecificCriteria) {
        this.dpSpecificCriteria = dpSpecificCriteria;
    }

    public DpSpecificCriteria getTxDpSpecificCriteria() {
        return dpSpecificCriteria;
    }

    @Override
    public int getApplicationTimer() {
        return dpSpecificCriteria.getApplicationTimer();
    }

    @Override
    public String toString() {
        return "TxCap2DPSpecificCriteriaWrapper [dpSpecificCriteria=" + dpSpecificCriteria + "]";
    }

}
