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

import org.mobicents.protocols.ss7.cap.api.primitives.ReceivingSideID;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.EventSpecificInformationBCSM;
import org.mobicents.protocols.ss7.inap.api.primitives.MiscCallInfo;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportBCSMArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventTypeBCSM;
import pl.ovoo.jslee.ss7.wrapper.cap.args.MiscCallInfoWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ReceivingSideIDWrapper;


/**
 * TxEventReportBCSMArgWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxEventReportBCSMArgWrapper implements EventReportBCSMArgWrapper {

    /** The tx event type bcsm. */
    private org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM txEventTypeBCSM;
    
    /** The tx leg id. */
    private ReceivingSideID txLegID;
    
    /** The tx event specific information bcsm. */
    private EventSpecificInformationBCSM txEventSpecificInformationBCSM;
    
    /** The tx misc call info. */
    private MiscCallInfo txMiscCallInfo;


    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportBCSMArgWrapper#getEventTypeBCSM()
     */
    @Override
    public EventTypeBCSM getEventTypeBCSM() {
        if (txEventTypeBCSM != null) {
            return EventTypeBCSM.valueOf(txEventTypeBCSM.getCode());
        }
        return null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportBCSMArgWrapper#setEventTypeBCSM(pl.ovoo.jslee.ss7.wrapper.cap.args.EventTypeBCSM)
     */
    @Override
    public void setEventTypeBCSM(final EventTypeBCSM eventTypeBCSM) {
        if (eventTypeBCSM == null) {
            txEventTypeBCSM = null;
        } else {
            txEventTypeBCSM = org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM.getInstance(eventTypeBCSM.getValue());
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportBCSMArgWrapper#getLegID()
     */
    @Override
    public ReceivingSideIDWrapper getLegID() {
        if (txLegID != null) {
            return new TxReceivingSideIDWrapper(txLegID);
        }
        return null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportBCSMArgWrapper#setLegID(pl.ovoo.jslee.ss7.wrapper.cap.args.ReceivingSideIDWrapper)
     */
    @Override
    public void setLegID(final ReceivingSideIDWrapper legID) {
        if (legID == null) {
            txLegID = null;
        } else {
            txLegID = ((TxReceivingSideIDWrapper) legID).getTxReceivingSideID();
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportBCSMArgWrapper#hasEventSpecificInformationBCSM()
     */
    @Override
    public boolean hasEventSpecificInformationBCSM() {
        return txEventSpecificInformationBCSM != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportBCSMArgWrapper#getEventSpecificInformationBCSM()
     */
    @Override
    public EventSpecificInformationBCSMWrapper getEventSpecificInformationBCSM() {
        if (txEventSpecificInformationBCSM != null) {
            return new TxEventSpecificInformationBCSMWrapper(txEventSpecificInformationBCSM);
        }
        return null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportBCSMArgWrapper#setEventSpecificInformationBCSM(pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationBCSMWrapper)
     */
    @Override
    public void setEventSpecificInformationBCSM(final EventSpecificInformationBCSMWrapper eventSpecificInformationBCSM) {
        if (eventSpecificInformationBCSM == null) {
            txEventSpecificInformationBCSM = null;
        } else {
            txEventSpecificInformationBCSM = ((TxEventSpecificInformationBCSMWrapper) eventSpecificInformationBCSM).getTxEventSpecificInformationBCSM();
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportBCSMArgWrapper#getMiscCallInfo()
     */
    @Override
    public MiscCallInfoWrapper getMiscCallInfo() {
        if (txMiscCallInfo != null) {
            return new TxMiscCallInfoWrapper(txMiscCallInfo);
        }
        return null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportBCSMArgWrapper#setMiscCallInfo(pl.ovoo.jslee.ss7.wrapper.cap.args.MiscCallInfoWrapper)
     */
    @Override
    public void setMiscCallInfo(final MiscCallInfoWrapper miscCallInfo) {
        if (miscCallInfo == null) {
            txMiscCallInfo = null;
        } else {
            txMiscCallInfo = ((TxMiscCallInfoWrapper) miscCallInfo).getTxMiscCallInfo();
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportBCSMArgWrapper#hasMiscCallInfo()
     */
    @Override
    public boolean hasMiscCallInfo() {
        return txMiscCallInfo != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportBCSMArgWrapper#hasLegID()
     */
    @Override
    public boolean hasLegID() {
        return txLegID != null;
    }


    /**
     * Gets the tx event type bcsm.
     *
     * @return the tx event type bcsm
     */
    public org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM getTxEventTypeBCSM() {
        return txEventTypeBCSM;
    }

    /**
     * Sets the tx event type bcsm.
     *
     * @param txEventTypeBCSM the new tx event type bcsm
     */
    public void setTxEventTypeBCSM(final org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM txEventTypeBCSM) {
        this.txEventTypeBCSM = txEventTypeBCSM;
    }

    /**
     * Gets the tx leg id.
     *
     * @return the tx leg id
     */
    public ReceivingSideID getTxLegID() {
        return txLegID;
    }

    /**
     * Sets the tx leg id.
     *
     * @param txLegID the new tx leg id
     */
    public void setTxLegID(final ReceivingSideID txLegID) {
        this.txLegID = txLegID;
    }

    /**
     * Gets the tx event specific information bcsm.
     *
     * @return the tx event specific information bcsm
     */
    public EventSpecificInformationBCSM getTxEventSpecificInformationBCSM() {
        return txEventSpecificInformationBCSM;
    }

    /**
     * Sets the tx event specific information bcsm.
     *
     * @param txEventSpecificInformationBCSM the new tx event specific information bcsm
     */
    public void setTxEventSpecificInformationBCSM(final EventSpecificInformationBCSM txEventSpecificInformationBCSM) {
        this.txEventSpecificInformationBCSM = txEventSpecificInformationBCSM;
    }

    /**
     * Gets the tx misc call info.
     *
     * @return the tx misc call info
     */
    public MiscCallInfo getTxMiscCallInfo() {
        return txMiscCallInfo;
    }

    /**
     * Sets the tx misc call info.
     *
     * @param txMiscCallInfo the new tx misc call info
     */
    public void setTxMiscCallInfo(final MiscCallInfo txMiscCallInfo) {
        this.txMiscCallInfo = txMiscCallInfo;
    }
}
