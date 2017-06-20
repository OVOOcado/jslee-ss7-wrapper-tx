/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.MOSMSCause;
import pl.ovoo.ss7.wrapper.cap.args.SMSCauseWrapper;

/**
 * TxCauseWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxSMSCauseWrapper implements SMSCauseWrapper {

    private MOSMSCause cause;

    public TxSMSCauseWrapper(final MOSMSCause cause) {
        this.cause = cause;
    }

    @Override
    public FailureCause getFailureCause() {
        if (cause != null) {
            return FailureCause.valueOf(cause.getCode());
        }
        return null;
    }

    @Override
    public void setFailureCause(final FailureCause failureCause) {
        cause = MOSMSCause.getInstance(failureCause.getValue());
    }

    public MOSMSCause getTxCause() {
        return cause;
    }

    @Override
    public String toString() {
        return "TxSMSCauseWrapper [cause=" + cause + "]";
    }

}
