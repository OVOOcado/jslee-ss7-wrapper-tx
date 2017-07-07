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

import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.RPCause;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RPCauseValue;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RPCauseWrapper;

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
