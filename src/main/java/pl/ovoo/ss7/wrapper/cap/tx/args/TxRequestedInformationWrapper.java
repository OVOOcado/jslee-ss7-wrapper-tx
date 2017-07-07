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

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformation;
import pl.ovoo.ss7.wrapper.cap.args.RequestedInformationType;
import pl.ovoo.ss7.wrapper.cap.args.RequestedInformationValueWrapper;
import pl.ovoo.ss7.wrapper.cap.args.RequestedInformationWrapper;

/**
 * OcRequestedInformationWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxRequestedInformationWrapper implements RequestedInformationWrapper {

    private transient RequestedInformationValueWrapper requestedInformationValue = null;

    private final RequestedInformation txRequestedInformation;

    public TxRequestedInformationWrapper(final RequestedInformation requestedInformation) {
        this.txRequestedInformation = requestedInformation;
    }

    @Override
    public boolean hasRequestedInformationType() {
        return txRequestedInformation.getRequestedInformationType() != null;
    }

    @Override
    public RequestedInformationType getRequestedInformationType() {
        if (txRequestedInformation.getRequestedInformationType() != null) {
            return RequestedInformationType.valueOf(txRequestedInformation.getRequestedInformationType().getCode());
        }
        return null;
    }

    @Override
    public boolean hasRequestedInformationValue() {
        return true;
    }

    @Override
    public RequestedInformationValueWrapper getRequestedInformationValue() {
        if (this.requestedInformationValue == null && txRequestedInformation != null)
            this.requestedInformationValue = new TxRequestedInformationValueWrapper(txRequestedInformation);
        return this.requestedInformationValue;
    }

    public RequestedInformation getTxRequestedInformation() {
        return txRequestedInformation;
    }

    @Override
    public String toString() {
        return "TxRequestedInformationWrapper [txRequestedInformation=" + txRequestedInformation + "]";
    }

}
