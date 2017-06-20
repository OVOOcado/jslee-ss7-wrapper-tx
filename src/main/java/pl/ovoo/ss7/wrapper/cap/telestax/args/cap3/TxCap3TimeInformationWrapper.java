/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap3;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.TimeInformation;
import pl.ovoo.ss7.wrapper.cap.args.cap3.Cap3TimeInformationWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2TimeInformationWrapper;

/**
 * TxCap3TimeInformationWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap3TimeInformationWrapper extends TxCap2TimeInformationWrapper implements Cap3TimeInformationWrapper {

    public TxCap3TimeInformationWrapper(final TimeInformation timeInformation) {
        super(timeInformation);
    }
}
