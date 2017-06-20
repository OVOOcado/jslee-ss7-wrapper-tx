/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.primitives.ReceivingSideID;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.EventSpecificInformationBCSM;
import org.mobicents.protocols.ss7.inap.api.primitives.MiscCallInfo;
import pl.ovoo.ss7.wrapper.cap.args.EventReportBCSMArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper;
import pl.ovoo.ss7.wrapper.cap.args.EventTypeBCSM;
import pl.ovoo.ss7.wrapper.cap.args.MiscCallInfoWrapper;
import pl.ovoo.ss7.wrapper.cap.args.ReceivingSideIDWrapper;

/**
 * TxEventReportBCSMArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxEventReportBCSMArgWrapper implements EventReportBCSMArgWrapper {

    private org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM txEventTypeBCSM;
    private ReceivingSideID txLegID;
    private EventSpecificInformationBCSM txEventSpecificInformationBCSM;
    private MiscCallInfo txMiscCallInfo;


    @Override
    public EventTypeBCSM getEventTypeBCSM() {
        if (txEventTypeBCSM != null) {
            return EventTypeBCSM.valueOf(txEventTypeBCSM.getCode());
        }
        return null;
    }

    @Override
    public void setEventTypeBCSM(final EventTypeBCSM eventTypeBCSM) {
        if (eventTypeBCSM == null) {
            txEventTypeBCSM = null;
        } else {
            txEventTypeBCSM = org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM.getInstance(eventTypeBCSM.getValue());
        }
    }

    @Override
    public ReceivingSideIDWrapper getLegID() {
        if (txLegID != null) {
            return new TxReceivingSideIDWrapper(txLegID);
        }
        return null;
    }

    @Override
    public void setLegID(final ReceivingSideIDWrapper legID) {
        if (legID == null) {
            txLegID = null;
        } else {
            txLegID = ((TxReceivingSideIDWrapper) legID).getTxReceivingSideID();
        }
    }

    @Override
    public boolean hasEventSpecificInformationBCSM() {
        return txEventSpecificInformationBCSM != null;
    }

    @Override
    public EventSpecificInformationBCSMWrapper getEventSpecificInformationBCSM() {
        if (txEventSpecificInformationBCSM != null) {
            return new TxEventSpecificInformationBCSMWrapper(txEventSpecificInformationBCSM);
        }
        return null;
    }

    @Override
    public void setEventSpecificInformationBCSM(final EventSpecificInformationBCSMWrapper eventSpecificInformationBCSM) {
        if (eventSpecificInformationBCSM == null) {
            txEventSpecificInformationBCSM = null;
        } else {
            txEventSpecificInformationBCSM = ((TxEventSpecificInformationBCSMWrapper) eventSpecificInformationBCSM).getTxEventSpecificInformationBCSM();
        }
    }

    @Override
    public MiscCallInfoWrapper getMiscCallInfo() {
        if (txMiscCallInfo != null) {
            return new TxMiscCallInfoWrapper(txMiscCallInfo);
        }
        return null;
    }

    @Override
    public void setMiscCallInfo(final MiscCallInfoWrapper miscCallInfo) {
        if (miscCallInfo == null) {
            txMiscCallInfo = null;
        } else {
            txMiscCallInfo = ((TxMiscCallInfoWrapper) miscCallInfo).getTxMiscCallInfo();
        }
    }

    @Override
    public boolean hasMiscCallInfo() {
        return txMiscCallInfo != null;
    }

    @Override
    public boolean hasLegID() {
        return txLegID != null;
    }


    public org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM getTxEventTypeBCSM() {
        return txEventTypeBCSM;
    }

    public void setTxEventTypeBCSM(final org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM txEventTypeBCSM) {
        this.txEventTypeBCSM = txEventTypeBCSM;
    }

    public ReceivingSideID getTxLegID() {
        return txLegID;
    }

    public void setTxLegID(final ReceivingSideID txLegID) {
        this.txLegID = txLegID;
    }

    public EventSpecificInformationBCSM getTxEventSpecificInformationBCSM() {
        return txEventSpecificInformationBCSM;
    }

    public void setTxEventSpecificInformationBCSM(final EventSpecificInformationBCSM txEventSpecificInformationBCSM) {
        this.txEventSpecificInformationBCSM = txEventSpecificInformationBCSM;
    }

    public MiscCallInfo getTxMiscCallInfo() {
        return txMiscCallInfo;
    }

    public void setTxMiscCallInfo(final MiscCallInfo txMiscCallInfo) {
        this.txMiscCallInfo = txMiscCallInfo;
    }
}
