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

package pl.ovoo.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventSpecificInformationSMS;
import pl.ovoo.ss7.wrapper.cap.args.EventReportSMSArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.EventSpecificInformationSMSWrapper;
import pl.ovoo.ss7.wrapper.cap.args.EventTypeSMS;

/**
 * OcSMSEventWrapperImpl
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxEventReportSMSArgWrapperImpl implements EventReportSMSArgWrapper {

	private org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventTypeSMS txEventTypeSMS;
    private EventSpecificInformationSMS txEventSpecificInformationSMS;

    public TxEventReportSMSArgWrapperImpl() {
    }

    @Override
    public EventTypeSMS getEventTypeSMS() {
        return EventTypeSMS.valueOf(txEventTypeSMS.getCode());
    }

    @Override
    public EventSpecificInformationSMSWrapper getEventSpecificInformationSMS() {
        return new TxEventSpecificInformationSMSWrapper(txEventSpecificInformationSMS);
    }

    @Override
    public boolean hasEventSpecificInformationSMS(){
    	return (txEventSpecificInformationSMS != null);
    }
    
    public void setTxEventSpecificInformationBCSM(EventSpecificInformationSMS txEventSpecificInformationSMS){
    	this.txEventSpecificInformationSMS = txEventSpecificInformationSMS;
    }
    
    public void setTxEventTypeSMS(org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventTypeSMS txEventTypeSMS){
    	this.txEventTypeSMS = txEventTypeSMS;
    }
}
