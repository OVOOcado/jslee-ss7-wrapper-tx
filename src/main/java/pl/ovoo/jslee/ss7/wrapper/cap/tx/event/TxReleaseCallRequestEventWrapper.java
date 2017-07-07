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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.event;

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.ReleaseCallRequest;
import org.mobicents.protocols.ss7.isup.message.parameter.CauseIndicators;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.ReleaseCallArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.ReleaseCallRequestEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxReleaseCallArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxReleaseCallRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxReleaseCallRequestEventWrapper extends TxEventWrapper implements ReleaseCallRequestEventWrapper {

    private final ReleaseCallRequest releaseCallRequest;

    public TxReleaseCallRequestEventWrapper(final ReleaseCallRequest releaseCallRequest, final ActivityContextInterface aci) {
        super(aci, releaseCallRequest);
        this.releaseCallRequest = releaseCallRequest;
    }

    @Override
    public ReleaseCallArgWrapper getArgument() throws Ss7WrapperException {
        try {
            final CauseIndicators causeIndicators;
            if (releaseCallRequest.getCause() != null) {
                causeIndicators = releaseCallRequest.getCause().getCauseIndicators();
            } else {
                causeIndicators = null;
            }
            final TxReleaseCallArgWrapper txReleaseCallArgWrapper = new TxReleaseCallArgWrapper();
            txReleaseCallArgWrapper.setTxCauseIndicators(causeIndicators);
            return txReleaseCallArgWrapper;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }
}
