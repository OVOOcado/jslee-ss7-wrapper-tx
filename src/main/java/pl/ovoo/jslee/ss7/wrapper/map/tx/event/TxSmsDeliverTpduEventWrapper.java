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

package pl.ovoo.jslee.ss7.wrapper.map.tx.event;

import org.mobicents.protocols.ss7.map.api.service.sms.ReportSMDeliveryStatusRequest;
import pl.ovoo.jslee.ss7.wrapper.common.args.SmDeliveryOutcome;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.map.event.SmsDeliverTpduEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSmsDeliverTpduWrapper;

import javax.slee.ActivityContextInterface;


/**
 * Created by karolsimka on 12.06.17.
 */
public class TxSmsDeliverTpduEventWrapper extends TxMapEventWrapper implements SmsDeliverTpduEventWrapper{

    /** The report sm delivery status request. */
    private final ReportSMDeliveryStatusRequest reportSMDeliveryStatusRequest;

    /**
     * Instantiates a new tx sms deliver tpdu event wrapper.
     *
     * @param reportSMDeliveryStatusRequest the report sm delivery status request
     * @param aci the aci
     */
    public TxSmsDeliverTpduEventWrapper(final ReportSMDeliveryStatusRequest reportSMDeliveryStatusRequest, final ActivityContextInterface aci) {
        super(aci);
        this.reportSMDeliveryStatusRequest = reportSMDeliveryStatusRequest;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.SmsDeliverTpduEventWrapper#getArgument()
     */
    @Override
    public TxSmsDeliverTpduWrapper getArgument() {
        TxSmsDeliverTpduWrapper smd = new TxSmsDeliverTpduWrapper();
        smd.setMsisdn(new TxISDNAddressStringWrapperImpl(reportSMDeliveryStatusRequest.getMsisdn()));
        smd.setSmDeliveryOutcome(SmDeliveryOutcome.valueOf(reportSMDeliveryStatusRequest.getSMDeliveryOutcome().getCode()));
        return smd;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.MapEventWrapper#getInvokeId()
     */
    @Override
    public long getInvokeId() {
        return reportSMDeliveryStatusRequest.getInvokeId();
    }

}
