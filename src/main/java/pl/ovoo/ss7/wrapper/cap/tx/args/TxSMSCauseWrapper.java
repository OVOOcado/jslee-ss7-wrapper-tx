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
