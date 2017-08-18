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

import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventSpecificInformationSMS;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationSMSWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventTypeSMS;


/**
 * OcSMSEventWrapperImpl.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxEventReportSMSArgWrapperImpl implements EventReportSMSArgWrapper {

	/** The tx event type sms. */
	private org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventTypeSMS txEventTypeSMS;
    
    /** The tx event specific information sms. */
    private EventSpecificInformationSMS txEventSpecificInformationSMS;

    /**
     * Instantiates a new tx event report sms arg wrapper impl.
     */
    public TxEventReportSMSArgWrapperImpl() {
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportSMSArgWrapper#getEventTypeSMS()
     */
    @Override
    public EventTypeSMS getEventTypeSMS() {
        return EventTypeSMS.valueOf(txEventTypeSMS.getCode());
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportSMSArgWrapper#getEventSpecificInformationSMS()
     */
    @Override
    public EventSpecificInformationSMSWrapper getEventSpecificInformationSMS() {
        return new TxEventSpecificInformationSMSWrapper(txEventSpecificInformationSMS);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventReportSMSArgWrapper#hasEventSpecificInformationSMS()
     */
    @Override
    public boolean hasEventSpecificInformationSMS(){
    	return (txEventSpecificInformationSMS != null);
    }
    
    /**
     * Sets the tx event specific information bcsm.
     *
     * @param txEventSpecificInformationSMS the new tx event specific information bcsm
     */
    public void setTxEventSpecificInformationBCSM(EventSpecificInformationSMS txEventSpecificInformationSMS){
    	this.txEventSpecificInformationSMS = txEventSpecificInformationSMS;
    }
    
    /**
     * Sets the tx event type sms.
     *
     * @param txEventTypeSMS the new tx event type sms
     */
    public void setTxEventTypeSMS(org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventTypeSMS txEventTypeSMS){
    	this.txEventTypeSMS = txEventTypeSMS;
    }
}
