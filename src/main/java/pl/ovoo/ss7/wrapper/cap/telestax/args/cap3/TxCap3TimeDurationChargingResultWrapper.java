/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap3;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.TimeDurationChargingResult;
import pl.ovoo.ss7.wrapper.cap.args.cap3.Cap3TimeDurationChargingResultWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2TimeDurationChargingResultWrapper;

/**
 * OcCap2TimeDurationChargingResultWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap3TimeDurationChargingResultWrapper extends TxCap2TimeDurationChargingResultWrapper implements Cap3TimeDurationChargingResultWrapper {


    public TxCap3TimeDurationChargingResultWrapper(final TimeDurationChargingResult timeDurationChargingResult) {
        super(timeDurationChargingResult);
    }
}
