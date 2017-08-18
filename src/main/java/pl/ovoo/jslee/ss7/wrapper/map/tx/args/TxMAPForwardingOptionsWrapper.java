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

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwOptions;
import pl.ovoo.jslee.ss7.wrapper.map.args.ForwardingReason;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPForwardingOptionsWrapper;


/**
 * TxMAPForwardingOptionsWrapper.
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPForwardingOptionsWrapper implements MAPForwardingOptionsWrapper {

    /** The ext forw options. */
    private final ExtForwOptions extForwOptions;

    /**
     * Instantiates a new tx map forwarding options wrapper.
     *
     * @param extForwOptions the ext forw options
     */
    public TxMAPForwardingOptionsWrapper(final ExtForwOptions extForwOptions) {
        this.extForwOptions = extForwOptions;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MAPForwardingOptionsWrapper#getForwardingReason()
     */
    @Override
    public ForwardingReason getForwardingReason() {
        if (extForwOptions.getExtForwOptionsForwardingReason() != null) {
            return ForwardingReason.valueOf(extForwOptions.getExtForwOptionsForwardingReason().getCode());
        }
        return null;
    }

    /**
     * Gets the tx ext forw options.
     *
     * @return the tx ext forw options
     */
    public ExtForwOptions getTxExtForwOptions() {
        return extForwOptions;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxMAPForwardingOptionsWrapper [extForwOptions=" + extForwOptions + "]";
    }

}
