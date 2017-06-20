/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.RPCause;
import pl.ovoo.ss7.wrapper.cap.args.RPCauseValue;
import pl.ovoo.ss7.wrapper.cap.args.RPCauseWrapper;

/**
 * TxRPCauseWrapperImpl
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxRPCauseWrapperImpl implements RPCauseWrapper {

    private final RPCause rpCause;

    public TxRPCauseWrapperImpl(final RPCause rpCause) {
        this.rpCause = rpCause;
    }

    @Override
    public RPCauseValue getRpCauseValue() {
        return RPCauseValue.valueOf(rpCause.getData());
    }

    public RPCause getTxRpCause() {
        return rpCause;
    }

    @Override
    public String toString() {
        return "TxRPCauseWrapperImpl [rpCause=" + rpCause + "]";
    }

}
