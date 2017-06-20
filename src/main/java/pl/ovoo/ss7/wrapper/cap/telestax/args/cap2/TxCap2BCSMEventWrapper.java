/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2;

import org.mobicents.protocols.ss7.cap.api.primitives.BCSMEvent;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2BCSMEventWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2DPSpecificCriteriaWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxBCSMEventWrapper;

/**
 * OcCap2BCSTxCap2BCSMEventWrapperMEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2BCSMEventWrapper extends TxBCSMEventWrapper implements Cap2BCSMEventWrapper {

    public TxCap2BCSMEventWrapper(final BCSMEvent bcsmEvent) {
        super(bcsmEvent);
    }

    @Override
    public boolean hasDPSpecificCriteria() {
        return bcsmEvent.getDpSpecificCriteria()!= null;
    }

    @Override
    public Cap2DPSpecificCriteriaWrapper getDPSpecificCriteria() {
        if (bcsmEvent.getDpSpecificCriteria()!= null) {
            return new TxCap2DPSpecificCriteriaWrapper(bcsmEvent.getDpSpecificCriteria());
        }
        return null;
    }
}
