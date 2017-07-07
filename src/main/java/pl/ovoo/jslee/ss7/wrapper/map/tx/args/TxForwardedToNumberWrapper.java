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
