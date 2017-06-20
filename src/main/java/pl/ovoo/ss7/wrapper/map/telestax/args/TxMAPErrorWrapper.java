/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.errors.MAPErrorMessage;
import pl.ovoo.ss7.wrapper.map.args.MAPErrorWrapper;

/**
 * TxMAPSubscriberIdentityWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPErrorWrapper implements MAPErrorWrapper {

    private final MAPErrorMessage mAPErrorMessage;

    public TxMAPErrorWrapper(final MAPErrorMessage mAPErrorMessage) {
        this.mAPErrorMessage = mAPErrorMessage;
    }

    public MAPErrorMessage getTxMAPErrorMessage() {
        return mAPErrorMessage;
    }

    @Override
    public String toString() {
        return "TxMAPErrorWrapper [mAPErrorMessage=" + mAPErrorMessage + "]";
    }

}
