/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.EventSpecificInformationSMS;
import pl.ovoo.ss7.wrapper.cap.args.EventSpecificInformationSMSWrapper;

/**
 * TxEventSpecificInformationSMSWrapperImpl
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxEventSpecificInformationSMSWrapper implements EventSpecificInformationSMSWrapper{

	private final EventSpecificInformationSMS eventSpecificInformationSMS;
	
	public TxEventSpecificInformationSMSWrapper(final EventSpecificInformationSMS eventSpecificInformationSMS) {
		this.eventSpecificInformationSMS = eventSpecificInformationSMS;
	}

	@Override
    public boolean isO_smsFailureSpecificInfoChosen() {
		return (this.eventSpecificInformationSMS.getOSmsFailureSpecificInfo() != null);
	}

	@Override
    public Integer getFailureCause() {
		return this.eventSpecificInformationSMS.getOSmsFailureSpecificInfo().getFailureCause().getCode();
	}
	
	@Override
    public boolean hasFailureCause() {
		return (this.eventSpecificInformationSMS.getOSmsFailureSpecificInfo().getFailureCause() != null);
	}
	
	public EventSpecificInformationSMS getEventSpecificInformationSMS(){
		return eventSpecificInformationSMS;
	}
}
