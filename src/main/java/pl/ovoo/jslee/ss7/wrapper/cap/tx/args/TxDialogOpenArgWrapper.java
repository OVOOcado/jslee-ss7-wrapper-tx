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

import org.mobicents.protocols.ss7.cap.api.CAPDialog;
import org.mobicents.protocols.ss7.sccp.parameter.SccpAddress;
import pl.ovoo.jslee.ss7.wrapper.cap.args.DialogOpenArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.SccpAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxSccpAddressWrapperImpl;


/**
 * TxDialogOpenArgWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogOpenArgWrapper implements DialogOpenArgWrapper {

    /** The local sccp address wrapper. */
    private SccpAddressWrapper localSccpAddressWrapper = null;
    
    /** The remote sccp address wrapper. */
    private SccpAddressWrapper remoteSccpAddressWrapper = null;

    /** The local sccp address. */
    private final SccpAddress localSccpAddress;
    
    /** The remote sccp address. */
    private final SccpAddress remoteSccpAddress;

    /**
     * Instantiates a new tx dialog open arg wrapper.
     *
     * @param dialog the dialog
     */
    public TxDialogOpenArgWrapper(final CAPDialog dialog) {
        localSccpAddress = dialog.getLocalAddress();
        remoteSccpAddress = dialog.getRemoteAddress();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.DialogOpenArgWrapper#getLocalSccpAddress()
     */
    @Override
    public SccpAddressWrapper getLocalSccpAddress() {
        if (this.localSccpAddressWrapper == null && this.localSccpAddress != null) {
            this.localSccpAddressWrapper = new TxSccpAddressWrapperImpl(localSccpAddress);
        }
        return this.localSccpAddressWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.DialogOpenArgWrapper#getRemoteSccpAddress()
     */
    @Override
    public SccpAddressWrapper getRemoteSccpAddress() {
        if (this.remoteSccpAddressWrapper == null && this.remoteSccpAddress != null) {
            this.remoteSccpAddressWrapper = new TxSccpAddressWrapperImpl(remoteSccpAddress);
        }
        return this.remoteSccpAddressWrapper;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxDialogOpenArgWrapper [localSccpAddress=" + localSccpAddress + ", remoteSccpAddress="
                + remoteSccpAddress + "]";
    }

}
