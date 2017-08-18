/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.map.tx.args;

import org.mobicents.protocols.ss7.map.api.primitives.AddressString;
import pl.ovoo.jslee.ss7.wrapper.map.args.ForwardedToNumberWrapper;


/**
 * TxForwardedToNumberWrapper.
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxForwardedToNumberWrapper implements ForwardedToNumberWrapper {

    /** The forwarded to number. */
    private final AddressString forwardedToNumber;

    /**
     * Instantiates a new tx forwarded to number wrapper.
     *
     * @param forwardedToNumber the forwarded to number
     */
    public TxForwardedToNumberWrapper(final AddressString forwardedToNumber) {
        this.forwardedToNumber = forwardedToNumber;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.ForwardedToNumberWrapper#getAddress()
     */
    @Override
    public String getAddress() {
        return forwardedToNumber.getAddress();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.ForwardedToNumberWrapper#getNature()
     */
    @Override
    public Nature getNature() {
        return Nature.valueOf(forwardedToNumber.getAddressNature().getIndicator());
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.ForwardedToNumberWrapper#getNumberingPlan()
     */
    @Override
    public NumberingPlan getNumberingPlan() {
        return NumberingPlan.valueOf(forwardedToNumber.getNumberingPlan().getIndicator());
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.ForwardedToNumberWrapper#hasAddress()
     */
    @Override
    public boolean hasAddress() {
        return forwardedToNumber.getAddress() != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.ForwardedToNumberWrapper#hasNature()
     */
    @Override
    public boolean hasNature() {
        return forwardedToNumber.getAddressNature() != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.ForwardedToNumberWrapper#hasNumberingPlan()
     */
    @Override
    public boolean hasNumberingPlan() {
        return forwardedToNumber.getNumberingPlan() != null;
    }

    /**
     * Gets the tx forwarded to number.
     *
     * @return the tx forwarded to number
     */
    public AddressString getTxForwardedToNumber() {
        return forwardedToNumber;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxForwardedToNumberWrapper [forwardedToNumber=" + forwardedToNumber + "]";
    }

}
