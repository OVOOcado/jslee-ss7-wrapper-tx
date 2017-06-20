/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.primitives.AddressString;
import pl.ovoo.ss7.wrapper.map.args.ForwardedToNumberWrapper;

/**
 * TxForwardedToNumberWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxForwardedToNumberWrapper implements ForwardedToNumberWrapper {

    private final AddressString forwardedToNumber;

    public TxForwardedToNumberWrapper(final AddressString forwardedToNumber) {
        this.forwardedToNumber = forwardedToNumber;
    }

    @Override
    public String getAddress() {
        return forwardedToNumber.getAddress();
    }

    @Override
    public Nature getNature() {
        return Nature.valueOf(forwardedToNumber.getAddressNature().getIndicator());
    }

    @Override
    public NumberingPlan getNumberingPlan() {
        return NumberingPlan.valueOf(forwardedToNumber.getNumberingPlan().getIndicator());
    }

    @Override
    public boolean hasAddress() {
        return forwardedToNumber.getAddress() != null;
    }

    @Override
    public boolean hasNature() {
        return forwardedToNumber.getAddressNature() != null;
    }

    @Override
    public boolean hasNumberingPlan() {
        return forwardedToNumber.getNumberingPlan() != null;
    }

    public AddressString getTxForwardedToNumber() {
        return forwardedToNumber;
    }

    @Override
    public String toString() {
        return "TxForwardedToNumberWrapper [forwardedToNumber=" + forwardedToNumber + "]";
    }

}
