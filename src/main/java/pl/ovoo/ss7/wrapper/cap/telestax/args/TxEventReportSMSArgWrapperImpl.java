/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

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
