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
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationSMSWrapper;


/**
 * TxEventSpecificInformationSMSWrapperImpl.
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxEventSpecificInformationSMSWrapper implements EventSpecificInformationSMSWrapper{

	/** The event specific information sms. */
	private final EventSpecificInformationSMS eventSpecificInformationSMS;
	
	/**
	 * Instantiates a new tx event specific information sms wrapper.
	 *
	 * @param eventSpecificInformationSMS the event specific information sms
	 */
	public TxEventSpecificInformationSMSWrapper(final EventSpecificInformationSMS eventSpecificInformationSMS) {
		this.eventSpecificInformationSMS = eventSpecificInformationSMS;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationSMSWrapper#isO_smsFailureSpecificInfoChosen()
	 */
	@Override
    public boolean isO_smsFailureSpecificInfoChosen() {
		return (this.eventSpecificInformationSMS.getOSmsFailureSpecificInfo() != null);
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationSMSWrapper#getFailureCause()
	 */
	@Override
    public Integer getFailureCause() {
		return this.eventSpecificInformationSMS.getOSmsFailureSpecificInfo().getFailureCause().getCode();
	}
	
	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.args.EventSpecificInformationSMSWrapper#hasFailureCause()
	 */
	@Override
    public boolean hasFailureCause() {
		return (this.eventSpecificInformationSMS.getOSmsFailureSpecificInfo().getFailureCause() != null);
	}
	
	/**
	 * Gets the event specific information sms.
	 *
	 * @return the event specific information sms
	 */
	public EventSpecificInformationSMS getEventSpecificInformationSMS(){
		return eventSpecificInformationSMS;
	}
}
