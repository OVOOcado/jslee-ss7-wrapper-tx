/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.MAPDialog;
import org.mobicents.protocols.ss7.sccp.parameter.SccpAddress;
import pl.ovoo.ss7.wrapper.common.args.SccpAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxSccpAddressWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.DialogOpenArgWrapper;

/**
 * TxDialogOpenArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogOpenArgWrapper implements DialogOpenArgWrapper {

    private transient SccpAddressWrapper localSccpAddressWrapper = null;
    private transient SccpAddressWrapper remoteSccpAddressWrapper = null;

    private final SccpAddress localSccpAddress;
    private final SccpAddress remoteSccpAddress;

    public TxDialogOpenArgWrapper(final MAPDialog dialog) {
        localSccpAddress = dialog.getLocalAddress();
        remoteSccpAddress = dialog.getRemoteAddress();
    }

    @Override
    public SccpAddressWrapper getLocalSccpAddress() {
        if (this.localSccpAddressWrapper == null && this.localSccpAddress != null) {
            this.localSccpAddressWrapper = new TxSccpAddressWrapperImpl(localSccpAddress);
        }
        return this.localSccpAddressWrapper;
    }

    @Override
    public SccpAddressWrapper getRemoteSccpAddress() {
        if (this.remoteSccpAddressWrapper == null && this.remoteSccpAddress != null) {
            this.remoteSccpAddressWrapper = new TxSccpAddressWrapperImpl(remoteSccpAddress);
        }
        return this.remoteSccpAddressWrapper;
    }

    @Override
    public String toString() {
        return "TxDialogOpenArgWrapper [localSccpAddress=" + localSccpAddress + ", remoteSccpAddress="
                + remoteSccpAddress + "]";
    }

}
