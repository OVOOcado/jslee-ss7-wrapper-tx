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
import pl.ovoo.ss7.wrapper.cap.args.CallInformationReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.RequestedInformationWrapper;

import java.util.ArrayList;

/**
 * TxCallInformationReportArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCallInformationReportArgWrapper implements CallInformationReportArgWrapper {

    private transient RequestedInformationWrapper[] requestedInformationList = null;

    private ArrayList<RequestedInformation> txRequestedInformation;

    @Override
    public RequestedInformationWrapper[] getRequestedInformationList() {
        if (this.requestedInformationList == null && this.txRequestedInformation != null) {
            final RequestedInformationWrapper[] requestedInformationWrappers = new RequestedInformationWrapper[txRequestedInformation
                    .size()];
            for (int i = 0; i < txRequestedInformation.size(); i++) {
                requestedInformationWrappers[i] = new TxRequestedInformationWrapper(txRequestedInformation.get(i));
            }
            this.requestedInformationList = requestedInformationWrappers;
        }
        return this.requestedInformationList;
    }

    @Override
    public void setRequestedInformationList(final RequestedInformationWrapper[] requestedInformationList) {
        if (requestedInformationList == null || requestedInformationList.length == 0) {
            this.txRequestedInformation = null;
            this.requestedInformationList = null;
        } else {
            this.txRequestedInformation = new ArrayList<RequestedInformation>(requestedInformationList.length);
            this.requestedInformationList = new RequestedInformationWrapper[requestedInformationList.length];
            for (int i = 0; i < requestedInformationList.length; i++) {
                final TxRequestedInformationWrapper requestedInformationWrapper = (TxRequestedInformationWrapper) requestedInformationList[i];
                this.txRequestedInformation.add(requestedInformationWrapper.getTxRequestedInformation());
                this.requestedInformationList[i] = requestedInformationWrapper;
            }
        }
    }

    public ArrayList<RequestedInformation> getTxRequestedInformation() {
        return txRequestedInformation;
    }

    public void setTxRequestedInformation(final ArrayList<RequestedInformation> txRequestedInformation) {
        this.requestedInformationList = null;
        this.txRequestedInformation = txRequestedInformation;
    }

    @Override
    public String toString() {
        return "TxCallInformationReportArgWrapper [txRequestedInformation=" + txRequestedInformation + "]";
    }

}
