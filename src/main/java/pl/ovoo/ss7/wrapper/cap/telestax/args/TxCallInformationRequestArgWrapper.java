/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import java.util.ArrayList;

import pl.ovoo.ss7.wrapper.cap.args.CallInformationRequestArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.RequestedInformationType;

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
