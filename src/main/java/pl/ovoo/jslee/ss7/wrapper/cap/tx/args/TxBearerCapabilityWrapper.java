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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.BearerCapability;
import pl.ovoo.jslee.ss7.wrapper.cap.args.BearerCapWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.BearerCapabilityWrapper;


/**
 * TxBearerCapabilityWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxBearerCapabilityWrapper implements BearerCapabilityWrapper {

    /** The bearer cap wrapper. */
    private transient BearerCapWrapper bearerCapWrapper = null;

    /** The bearer capability. */
    private final BearerCapability bearerCapability;

    /**
     * Instantiates a new tx bearer capability wrapper.
     *
     * @param bearerCapability the bearer capability
     */
    public TxBearerCapabilityWrapper(final BearerCapability bearerCapability) {
        this.bearerCapability = bearerCapability;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.BearerCapabilityWrapper#getBearerCap()
     */
    @Override
    public BearerCapWrapper getBearerCap() {
        if (this.bearerCapWrapper == null && bearerCapability.getBearerCap() != null) {
            this.bearerCapWrapper = new TxBearerCapWrapper(bearerCapability.getBearerCap());
        }
        return this.bearerCapWrapper;
    }

    /**
     * Gets the tx bearer capability.
     *
     * @return the tx bearer capability
     */
    public BearerCapability getTxBearerCapability() {
        return bearerCapability;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxBearerCapabilityWrapper [bearerCapability=" + bearerCapability + "]";
    }

}
