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

import java.util.ArrayList;

import pl.ovoo.jslee.ss7.wrapper.cap.args.CallInformationRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RequestedInformationType;

/**
 * TxCallInformationRequestArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCallInformationRequestArgWrapper implements CallInformationRequestArgWrapper {

    private transient RequestedInformationType[] requestedInformationTypeList = null;

    private ArrayList<org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformationType> txRequestedInformationTypes;

    @Override
    public void setRequestedInformationTypeList(final RequestedInformationType[] requestedInformationTypeList) {
        if (requestedInformationTypeList == null || requestedInformationTypeList.length == 0) {
            this.txRequestedInformationTypes = null;
            this.requestedInformationTypeList = null;
        } else {
            this.txRequestedInformationTypes = new ArrayList<org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformationType>(
                    requestedInformationTypeList.length);
            this.requestedInformationTypeList = new RequestedInformationType[requestedInformationTypeList.length];

            for (int i = 0; i < requestedInformationTypeList.length; i++) {
                final int value = requestedInformationTypeList[i].getValue();
                this.txRequestedInformationTypes
                        .add(org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformationType
                                .getInstance(value));
                this.requestedInformationTypeList[i] = RequestedInformationType.valueOf(value);

            }
        }
    }

    @Override
    public RequestedInformationType[] getRequestedInformationTypeList() {
        if (this.requestedInformationTypeList == null && this.txRequestedInformationTypes != null) {
            final RequestedInformationType[] requestedInformationTypes = new RequestedInformationType[txRequestedInformationTypes
                    .size()];
            for (int i = 0; i < txRequestedInformationTypes.size(); i++) {
                requestedInformationTypes[i] = RequestedInformationType
                        .valueOf(txRequestedInformationTypes.get(i).getCode());
            }
            this.requestedInformationTypeList = requestedInformationTypes;
        }
        return this.requestedInformationTypeList;
    }

    public ArrayList<org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformationType> getTxRequestedInformationTypes() {
        return txRequestedInformationTypes;
    }

    public void setTxRequestedInformationTypes(
            final ArrayList<org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformationType> txRequestedInformationTypes) {
        this.txRequestedInformationTypes = txRequestedInformationTypes;
        this.requestedInformationTypeList = null;
    }

    @Override
    public String toString() {
        return "TxCallInformationRequestArgWrapper [txRequestedInformationTypes=" + txRequestedInformationTypes + "]";
    }

}
