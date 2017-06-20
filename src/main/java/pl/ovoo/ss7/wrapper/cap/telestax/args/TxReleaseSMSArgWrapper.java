/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.RPCause;
import pl.ovoo.ss7.wrapper.cap.args.RPCauseWrapper;
import pl.ovoo.ss7.wrapper.cap.args.ReleaseSMSArgWrapper;

/**
 * TxReleaseCallArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxReleaseSMSArgWrapper implements ReleaseSMSArgWrapper {

    private transient RPCauseWrapper rpCauseWrapper = null;

    private RPCause rpCause;

    public TxReleaseSMSArgWrapper(final RPCause rpCause) {
        this.rpCause = rpCause;
    }

    @Override
    public RPCauseWrapper getRPCause() {
        if (this.rpCauseWrapper == null && this.rpCause != null) {
            this.rpCauseWrapper = new TxRPCauseWrapperImpl(rpCause);
        }
        return this.rpCauseWrapper;
    }

    @Override
    public String toString() {
        return "TxReleaseSMSArgWrapper [rpCause=" + rpCause + "]";
    }

}
