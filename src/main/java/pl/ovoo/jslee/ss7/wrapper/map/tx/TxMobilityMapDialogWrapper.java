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

package pl.ovoo.jslee.ss7.wrapper.map.tx;

import java.util.ArrayList;
import java.util.Arrays;

import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.service.mobility.MAPDialogMobility;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtSSInfo;
import org.mobicents.slee.resource.map.service.mobility.wrappers.MAPDialogMobilityWrapper;

import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.map.MobilityMapDialogWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.AnyTimeInterrogationArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.AnyTimeInterrogationResultWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.AnyTimeSubscriptionInterrogationArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.InsertSubscriberDataArg_v1Wrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPSubscriberInfoWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxAnyTimeInterrogationArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxInsertSubscriberDataArg_v1Wrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxMAPSubscriberInfoWrapper;

/**
 * TxMapDialogWrapperImpl
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxMobilityMapDialogWrapper extends TxMapDialogWrapperImpl implements MobilityMapDialogWrapper {
    
    private MAPDialogMobility dialog;

    public TxMobilityMapDialogWrapper(final MAPDialogMobility dialog) {
        super(dialog);
        this.dialog = dialog;
    }
    
    @Override
    public void sendAnyTimeInterrogation(long atiTimeout, AnyTimeInterrogationArgWrapper arg) throws Ss7WrapperException {
    	try {
            TxAnyTimeInterrogationArgWrapper txArg = (TxAnyTimeInterrogationArgWrapper)arg;
            dialog.addAnyTimeInterrogationRequest(atiTimeout,
            		txArg.getTxSubscriberIdentity(),
            		txArg.getTxRequestedInfo(),
            		txArg.getTxGsmScfAddress(),
            		null);
            
        } catch (MAPException e) {
            throw new Ss7WrapperException(e);
        }
    }
    
    @Override
    public void sendAnyTimeInterrogationResponse(long invoke, AnyTimeInterrogationResultWrapper arg) throws Ss7WrapperException {
    	try {
		    MAPSubscriberInfoWrapper mAPSubscriberInfoWrapper = arg.getSubscriberInfo();
		    if(mAPSubscriberInfoWrapper != null && ((TxMAPSubscriberInfoWrapper)mAPSubscriberInfoWrapper).getTxSubscriberInfo() != null){
		    	((MAPDialogMobilityWrapper)dialog).getWrappedDialog().addAnyTimeInterrogationResponse(invoke,
		            	((TxMAPSubscriberInfoWrapper)mAPSubscriberInfoWrapper).getTxSubscriberInfo(),
		            	null);
		    }
		} catch (MAPException e) {
		    throw new Ss7WrapperException(e);
		}
    }
    
    @Override
    public void sendAnyTimeSubscriptionInterrogation(long atiTimeout, AnyTimeSubscriptionInterrogationArgWrapper arg) throws Ss7WrapperException {
    	//try {
            //TxAnyTimeSubscriptionInterrogationArgWrapper txArg = (TxAnyTimeSubscriptionInterrogationArgWrapper)arg;
            //TODO upgrade to newer version of restcomm map-api
            //dialog.addAnyTimeSubscriptionInterrogationRequest(atiTimeout,
            //		txArg.getTxSubscriberIdentity(),
            //		txArg.getTxRequestedSubscriptionInfo(),
            //		txArg.getTxGsmScfAddress(),
            //		null);
        //} catch (MAPException e) {
        //    throw new Ss7WrapperException(e);
        //}
    }
    
    @Override
    public void sendInsertSubscriberDataArg_v1(long isdTimeout, InsertSubscriberDataArg_v1Wrapper arg) throws Ss7WrapperException {
    	try {
            TxInsertSubscriberDataArg_v1Wrapper txArg = (TxInsertSubscriberDataArg_v1Wrapper)arg;
            dialog.addInsertSubscriberDataRequest(
            		isdTimeout, 
            		txArg.getTxImsi(),
            		null, null, null, null, null,
            		new ArrayList<ExtSSInfo>(Arrays.asList(txArg.getTxProvisionedSS())),
            		null, false, null, null, null, null);
        } catch (MAPException e) {
            throw new Ss7WrapperException(e);
        }
    }
    
    @Override
    public void sendInsertSubscriberDataResponse(long invoke) throws Ss7WrapperException {
    	try {
    		dialog.addInsertSubscriberDataResponse(invoke, null, null, null, null, null);
		} catch (MAPException e) {
            throw new Ss7WrapperException(e);
		}
    }

	public MAPDialogMobility getDialog() {
		return dialog;
	}
    
    
}
