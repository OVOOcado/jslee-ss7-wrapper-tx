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

package pl.ovoo.jslee.ss7.wrapper.map.tx.args;

import java.nio.charset.Charset;
import java.util.ArrayList;

import org.mobicents.protocols.ss7.map.api.MAPApplicationContext;
import org.mobicents.protocols.ss7.map.api.MAPApplicationContextName;
import org.mobicents.protocols.ss7.map.api.MAPApplicationContextVersion;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.MAPParameterFactory;
import org.mobicents.protocols.ss7.map.api.MAPProvider;
import org.mobicents.protocols.ss7.map.api.dialog.MAPUserAbortChoice;
import org.mobicents.protocols.ss7.map.api.errors.MAPErrorMessage;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.AddressString;
import org.mobicents.protocols.ss7.map.api.primitives.CellGlobalIdOrServiceAreaIdOrLAI;
import org.mobicents.protocols.ss7.map.api.primitives.FTNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.primitives.SubscriberIdentity;
import org.mobicents.protocols.ss7.map.api.service.callhandling.MAPDialogCallHandling;
import org.mobicents.protocols.ss7.map.api.service.mobility.MAPDialogMobility;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.AnyTimeInterrogationRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.LocationInformation;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.RequestedInfo;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberInfo;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBasicServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwFeature;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwInfo;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwOptions;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwOptionsForwardingReason;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtSSInfo;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtSSStatus;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtTeleserviceCode;
import org.mobicents.protocols.ss7.map.api.service.supplementary.SSForBSCode;
import org.mobicents.protocols.ss7.map.api.service.supplementary.SupplementaryCodeValue;
import org.mobicents.protocols.ss7.sccp.parameter.SccpAddress;
import org.mobicents.slee.resource.map.MAPContextInterfaceFactory;

import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.IMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.SccpAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxAddressStringWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxSccpAddressWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.map.CallHandlingMapDialogWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.MapApplicationContextWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.MobilityMapDialogWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.*;
import pl.ovoo.jslee.ss7.wrapper.map.tx.TxCallHandlingMapDialogWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.TxMobilityMapDialogWrapper;


/**
 * TxArgsFactory.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxMapArgsFactory implements MapArgsFactory {

	/** The map provider. */
	private MAPProvider mapProvider;
	
	/** The map parameter factory. */
	private MAPParameterFactory mapParameterFactory;
	
	/** The map context interface factory. */
	private MAPContextInterfaceFactory mapContextInterfaceFactory;

    /**
     * Instantiates a new tx map args factory.
     *
     * @param mapParameterFactory the map parameter factory
     */
    public TxMapArgsFactory(final MAPParameterFactory mapParameterFactory) {
        this.mapParameterFactory = mapParameterFactory;
    }

    /**
     * Instantiates a new tx map args factory.
     *
     * @param mapProvider the map provider
     */
    public TxMapArgsFactory(final MAPProvider mapProvider) {
        this.mapProvider = mapProvider;
        this.mapParameterFactory = mapProvider.getMAPParameterFactory();
    }

    /**
     * Instantiates a new tx map args factory.
     *
     * @param mapProvider the map provider
     * @param mapContextInterfaceFactory the map context interface factory
     */
    public TxMapArgsFactory(final MAPProvider mapProvider, final MAPContextInterfaceFactory mapContextInterfaceFactory) {
		super();
        this.mapParameterFactory = mapProvider.getMAPParameterFactory();
		this.mapProvider = mapProvider;
		this.mapContextInterfaceFactory = mapContextInterfaceFactory;
	}



	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createMapLocationInformation(pl.ovoo.jslee.ss7.wrapper.map.args.MAPCellGlobalIdOrServiceAreaIdOrLAIWrapper, pl.ovoo.jslee.ss7.wrapper.common.args.ISDNAddressStringWrapper)
	 */
	@Override
    public MAPLocationInformationWrapper createMapLocationInformation(final MAPCellGlobalIdOrServiceAreaIdOrLAIWrapper mapCellGlobalIdOrServiceAreaIdOrLAI,
                                                                      final ISDNAddressStringWrapper vlrNumber) {
        final CellGlobalIdOrServiceAreaIdOrLAI cellGlobalIdOrServiceAreaIdOrLAI;
        if (mapCellGlobalIdOrServiceAreaIdOrLAI == null) {
            cellGlobalIdOrServiceAreaIdOrLAI = null;
        } else {
            final TxMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper txMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper = (TxMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper) mapCellGlobalIdOrServiceAreaIdOrLAI;
            cellGlobalIdOrServiceAreaIdOrLAI = txMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper.getTxCellGlobalIdOrServiceAreaIdOrLAI();

        }
        final ISDNAddressString vlrNumberTx;
        if (vlrNumber == null) {
            vlrNumberTx = null;
        } else {
            final TxISDNAddressStringWrapperImpl txISDNAddressStringWrapper = (TxISDNAddressStringWrapperImpl) vlrNumber;
            vlrNumberTx = txISDNAddressStringWrapper.getTxAddress();
        }
        final LocationInformation locationInformation = mapParameterFactory.createLocationInformation(null,
                null, vlrNumberTx, null, cellGlobalIdOrServiceAreaIdOrLAI, null,
                null, null, null, false, false, null, null);
        return new TxMAPLocationInformationWrapper(locationInformation);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createIsdnAddressString(pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper.Nature, pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper.NumberingPlan, java.lang.String)
     */
    @Override
    public ISDNAddressStringWrapper createIsdnAddressString(final ISDNAddressStringWrapper.Nature nature,
                                                            final ISDNAddressStringWrapper.NumberingPlan numberingPlan,
                                                            final String address) {
        final AddressNature addressNature;
        if (nature == null) {
            addressNature = null;
        } else {
            addressNature = AddressNature.getInstance(nature.getValue());
        }

        final NumberingPlan numberingPlanTx;
        if (numberingPlan == null) {
            numberingPlanTx = null;
        } else {
            numberingPlanTx = NumberingPlan.getInstance(numberingPlan.getValue());
        }
        final ISDNAddressString isdnAddressString = mapParameterFactory.createISDNAddressString(addressNature, numberingPlanTx, address);
        return new TxISDNAddressStringWrapperImpl(isdnAddressString);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createAddressString(pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper.Nature, pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper.NumberingPlan, java.lang.String)
     */
    @Override
    public AddressStringWrapper createAddressString(final ISDNAddressStringWrapper.Nature nature,
													 final ISDNAddressStringWrapper.NumberingPlan numberingPlan,
													 final String address){
		final AddressNature addressNature;
		if (nature == null) {
			addressNature = null;
		} else {
			addressNature = AddressNature.getInstance(nature.getValue());
		}

		final NumberingPlan numberingPlanTx;
		if (numberingPlan == null) {
			numberingPlanTx = null;
		} else {
			numberingPlanTx = NumberingPlan.getInstance(numberingPlan.getValue());
		}
		final AddressString addressString = mapParameterFactory.createAddressString(addressNature, numberingPlanTx, address);
		return new TxAddressStringWrapperImpl(addressString);
	}

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createForwardedToNumber(pl.ovoo.jslee.ss7.wrapper.map.args.ForwardedToNumberWrapper.Nature, pl.ovoo.jslee.ss7.wrapper.map.args.ForwardedToNumberWrapper.NumberingPlan, java.lang.String)
     */
    @Override
    public ForwardedToNumberWrapper createForwardedToNumber(final ForwardedToNumberWrapper.Nature nature,
    		final ForwardedToNumberWrapper.NumberingPlan numberingPlan,
    		final String address) {
        final AddressNature addressNature;
        if (nature == null) {
            addressNature = null;
        } else {
            addressNature = AddressNature.getInstance(nature.getValue());
        }

        final NumberingPlan numberingPlanTx;
        if (numberingPlan == null) {
            numberingPlanTx = null;
        } else {
            numberingPlanTx = NumberingPlan.getInstance(numberingPlan.getValue());
        }
        final FTNAddressString ftnAddressString = mapParameterFactory.createFTNAddressString(addressNature, numberingPlanTx, address);
        return new TxForwardedToNumberWrapper(ftnAddressString);
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createMAPSubscriberIdentity(pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper)
     */
    @Override
    public MAPSubscriberIdentityWrapper createMAPSubscriberIdentity(AddressStringWrapper msisdn){
    	ISDNAddressString txMsisdn = ((TxISDNAddressStringWrapperImpl)msisdn).getTxAddress();
    	SubscriberIdentity subscriberIdentity = mapParameterFactory.createSubscriberIdentity(txMsisdn);
    	return new TxMAPSubscriberIdentityWrapper(subscriberIdentity);
    	
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createAnyTimeInterrogationResult(pl.ovoo.jslee.ss7.wrapper.map.args.MAPSubscriberInfoWrapper)
     */
    @Override
    public AnyTimeInterrogationResultWrapper createAnyTimeInterrogationResult(MAPSubscriberInfoWrapper mAPSubscriberInfoWrapper){
    	AnyTimeInterrogationResultWrapper atiResult = new TxAnyTimeInterrogationResultWrapper(
    			mAPSubscriberInfoWrapper);    	
    	return atiResult;
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createMAPSubscriberInfoWrapper(pl.ovoo.jslee.ss7.wrapper.map.args.MAPLocationInformationWrapper)
     */
    @Override
    public MAPSubscriberInfoWrapper createMAPSubscriberInfoWrapper(MAPLocationInformationWrapper mAPLocationInformationWrapper){
    	SubscriberInfo mAPSubscriberInfo = mapParameterFactory.createSubscriberInfo(
    			((TxMAPLocationInformationWrapper)mAPLocationInformationWrapper).getTxMapLocationInformation(), 
    			null, null, null, null, null, null, null, null);
    	return new TxMAPSubscriberInfoWrapper(mAPSubscriberInfo);
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createAnyTimeInterrogationArg(pl.ovoo.jslee.ss7.wrapper.map.args.MAPSubscriberIdentityWrapper, pl.ovoo.jslee.ss7.wrapper.map.args.MAPRequestedInfoWrapper, pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper)
     */
    @Override
    public AnyTimeInterrogationArgWrapper createAnyTimeInterrogationArg(MAPSubscriberIdentityWrapper subscriberIdentity, MAPRequestedInfoWrapper mAPRequestedInfo, AddressStringWrapper gsmSCF_Address){
    	AnyTimeInterrogationRequest ati = mapParameterFactory.createAnyTimeInterrogationRequest(
    			((TxMAPSubscriberIdentityWrapper)subscriberIdentity).getTxMAPSubscriberIdentity(), 
    			((TxMAPRequestedInfoWrapper)mAPRequestedInfo).getTxRequestedInfo(), 
    			((TxISDNAddressStringWrapperImpl)gsmSCF_Address).getTxAddress(), 
    			null);
    	AnyTimeInterrogationArgWrapper atiWrapper = new TxAnyTimeInterrogationArgWrapper(ati);
    	
    	return atiWrapper;
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createCallHandlingMapDialogWrapper(pl.ovoo.jslee.ss7.wrapper.map.MapApplicationContextWrapper, pl.ovoo.jslee.ss7.wrapper.common.args.SccpAddressWrapper, pl.ovoo.jslee.ss7.wrapper.common.args.SccpAddressWrapper)
     */
    @Override
    public CallHandlingMapDialogWrapper createCallHandlingMapDialogWrapper(MapApplicationContextWrapper mapApplicationContextWrapper, SccpAddressWrapper srcAddress, SccpAddressWrapper destAddress) throws Ss7WrapperException {
        try{
            MAPApplicationContext ac;
            if (mapApplicationContextWrapper.equals(MapApplicationContextWrapper.locationInfoRetrievalContext_v3_ac)){
                ac = MAPApplicationContext.getInstance(MAPApplicationContextName.locationInfoRetrievalContext,
                        MAPApplicationContextVersion.version3);
            }else{
                throw new Ss7WrapperException("Unknown MAP application context");
            }
            SccpAddress destinationAddress = ((TxSccpAddressWrapperImpl)destAddress).getTxSccpAddress();
            SccpAddress sourceAddress = ((TxSccpAddressWrapperImpl)srcAddress).getTxSccpAddress();
            
            MAPDialogCallHandling dialog = mapProvider.getMAPServiceCallHandling().createNewDialog(ac, sourceAddress, null,
                    destinationAddress, null);
            
            TxCallHandlingMapDialogWrapper dialogWrapper = new TxCallHandlingMapDialogWrapper(dialog);
            dialogWrapper.setActivityContextInterface(mapContextInterfaceFactory.getActivityContextInterface(dialog));
            return dialogWrapper;
        }
        catch(MAPException e){
            throw new Ss7WrapperException(e);
        }
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createMobilityMapDialogWrapper(pl.ovoo.jslee.ss7.wrapper.map.MapApplicationContextWrapper, pl.ovoo.jslee.ss7.wrapper.common.args.SccpAddressWrapper, pl.ovoo.jslee.ss7.wrapper.common.args.SccpAddressWrapper)
     */
    @Override
    public MobilityMapDialogWrapper createMobilityMapDialogWrapper(MapApplicationContextWrapper mapApplicationContextWrapper, SccpAddressWrapper srcAddress, SccpAddressWrapper destAddress) throws Ss7WrapperException {
    	try{
	    	MAPApplicationContext ac;
	    	if (mapApplicationContextWrapper.equals(MapApplicationContextWrapper.anyTimeInfoEnquiryContext_v3_ac)){
	    		ac = MAPApplicationContext.getInstance(MAPApplicationContextName.anyTimeEnquiryContext,
	                    MAPApplicationContextVersion.version3);
	    	}
	    	else if (mapApplicationContextWrapper.equals(MapApplicationContextWrapper.anyTimeInfoHandlingContext_v3_ac)){
	    		ac = MAPApplicationContext.getInstance(MAPApplicationContextName.anyTimeInfoHandlingContext,
	                    MAPApplicationContextVersion.version3);
	    	}
	    	else if (mapApplicationContextWrapper.equals(MapApplicationContextWrapper.subscriberDataMngtContext_v2_ac)){
	    		ac = MAPApplicationContext.getInstance(MAPApplicationContextName.subscriberDataMngtContext,
	                    MAPApplicationContextVersion.version2);
	    	}
	    	else{
	    		throw new Ss7WrapperException("Unknown MAP application context");
	    	}
	    	SccpAddress destinationAddress = ((TxSccpAddressWrapperImpl)destAddress).getTxSccpAddress();
	    	SccpAddress sourceAddress = ((TxSccpAddressWrapperImpl)srcAddress).getTxSccpAddress();
	    	
	    	MAPDialogMobility dialog = mapProvider.getMAPServiceMobility().createNewDialog(ac, sourceAddress, null,
	    			destinationAddress, null);
	    	
	    	TxMobilityMapDialogWrapper dialogWrapper = new TxMobilityMapDialogWrapper(dialog);
	    	dialogWrapper.setActivityContextInterface(mapContextInterfaceFactory.getActivityContextInterface(dialog));
	    	return dialogWrapper;
    	}
    	catch(MAPException e){
    		throw new Ss7WrapperException(e);
    	}
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createAnyTimeSubscriptionInterrogationArg(pl.ovoo.jslee.ss7.wrapper.map.args.MAPSubscriberIdentityWrapper, pl.ovoo.jslee.ss7.wrapper.map.args.MAPRequestedSubscriptionInfoWrapper, pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper)
     */
    @Override
    public AnyTimeSubscriptionInterrogationArgWrapper createAnyTimeSubscriptionInterrogationArg(MAPSubscriberIdentityWrapper subscriberIdentity, MAPRequestedSubscriptionInfoWrapper mAPRequestedInfo, AddressStringWrapper gsmSCF_Address){
    	AnyTimeSubscriptionInterrogationArgWrapper ati = new TxAnyTimeSubscriptionInterrogationArgWrapper();
    	ati.setSubscriberIdentity(subscriberIdentity);
    	ati.setGsmSCF_Address(gsmSCF_Address);
    	ati.setRequestedSubscriptionInfo(mAPRequestedInfo);
    	
    	return ati;
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createMAPRequestedSubscriptionInfoWrapper(pl.ovoo.jslee.ss7.wrapper.map.args.MAPSS_ForBS_CodeWrapper)
     */
    @Override
    public MAPRequestedSubscriptionInfoWrapper createMAPRequestedSubscriptionInfoWrapper(MAPSS_ForBS_CodeWrapper ssForBSCode){
    	//TODO upgrade to newer version of restcomm map-api
    	//RequestedSubscriptionInfo requestedSubscriptionInfo = mapParameterFactory.createRequestedSubscriptionInfo(ssForBSCode);
//    	final SSForBSCode txSSForBSCode;
//    	if(ssForBSCode != null){
//    		txSSForBSCode = ((TxMAPSS_ForBS_CodeWrapper)ssForBSCode).getTxSSForBSCode();
//    	}
//    	else{
//    		txSSForBSCode = null;
//    	}

    	return new TxMAPRequestedSubscriptionInfoWrapper(null);
    	
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createMAPSS_ForBS_CodeWrapper(pl.ovoo.jslee.ss7.wrapper.map.args.SSCode)
     */
    @Override
    public MAPSS_ForBS_CodeWrapper createMAPSS_ForBS_CodeWrapper(SSCode ssCode){
    	org.mobicents.protocols.ss7.map.api.service.supplementary.SSCode txSSCode = null;
    	switch(ssCode){
    		case ALL_FORWARDING_SS: txSSCode =  mapParameterFactory.createSSCode(SupplementaryCodeValue.allForwardingSS);
    	}
    	SSForBSCode txSSForBSCode = mapParameterFactory.createSSForBSCode(txSSCode, null, false);
    	return new TxMAPSS_ForBS_CodeWrapper(txSSForBSCode);
    	
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createInsertSubscriberDataArg_v1Wrapper(pl.ovoo.jslee.ss7.wrapper.map.args.MAPSS_InformationWrapper[], pl.ovoo.jslee.ss7.wrapper.common.args.IMSIAddressWrapper)
     */
    @Override
    public InsertSubscriberDataArg_v1Wrapper createInsertSubscriberDataArg_v1Wrapper(MAPSS_InformationWrapper[] mapss_Informations, IMSIAddressWrapper imsi){
    	final InsertSubscriberDataArg_v1Wrapper isd = new TxInsertSubscriberDataArg_v1Wrapper(null);
    	isd.setImsi(imsi);
    	isd.setProvisionedSS(mapss_Informations);
    	
    	return isd;
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createMAPSS_InformationWrapper(pl.ovoo.jslee.ss7.wrapper.map.args.MAPForwardingInfoWrapper)
     */
    @Override
    public MAPSS_InformationWrapper createMAPSS_InformationWrapper(MAPForwardingInfoWrapper mAPForwardingInfoWrapper){
    	final ExtSSInfo extSSInfo = mapParameterFactory.createExtSSInfo(((TxMAPForwardingInfoWrapper)mAPForwardingInfoWrapper).getTxExtForwInfo());
    	return new TxMAPSS_InformationWrapper(extSSInfo);
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createMAPForwardingInfoWrapper(pl.ovoo.jslee.ss7.wrapper.map.args.MAPForwardingFeatureWrapper[], pl.ovoo.jslee.ss7.wrapper.map.args.SSCode)
     */
    @Override
    public MAPForwardingInfoWrapper createMAPForwardingInfoWrapper(MAPForwardingFeatureWrapper[] mapForwardingFeatures, SSCode ss_Code){
    	ArrayList<ExtForwFeature> txMapForwardingFeatures = null;
    	if(mapForwardingFeatures != null){
    		txMapForwardingFeatures = new ArrayList<ExtForwFeature>();
    		for(MAPForwardingFeatureWrapper mapForwardingFeature : mapForwardingFeatures){
    			txMapForwardingFeatures.add(((TxMAPForwardingFeatureWrapper)mapForwardingFeature).getTxExtForwFeature());
    		}
    	}
    	org.mobicents.protocols.ss7.map.api.service.supplementary.SSCode txSSCode = null;
    	if(ss_Code != null){
    		switch(ss_Code){
    			case CFB: txSSCode = mapParameterFactory.createSSCode(SupplementaryCodeValue.cfb);
    			break;
    			case CFNRC: txSSCode = mapParameterFactory.createSSCode(SupplementaryCodeValue.cfnrc);
    			break;
    			case CFNRY: txSSCode = mapParameterFactory.createSSCode(SupplementaryCodeValue.cfnry);
    			break;
    			case CFU: txSSCode = mapParameterFactory.createSSCode(SupplementaryCodeValue.cfu);
    			break;
    			default: break;
    		}
    	}    	
    	final ExtForwInfo extForwInfo = mapParameterFactory.createExtForwInfo(txSSCode, txMapForwardingFeatures, null);
    	return new TxMAPForwardingInfoWrapper(extForwInfo);
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createMAPForwardingFeatureWrapper(pl.ovoo.jslee.ss7.wrapper.map.args.MAPExt_ForwFeatureWrapper)
     */
    @Override
    public MAPForwardingFeatureWrapper createMAPForwardingFeatureWrapper(MAPExt_ForwFeatureWrapper mAPExt_ForwFeatureWrapper){
    	if(mAPExt_ForwFeatureWrapper != null){
    		TxMAPExt_ForwFeatureWrapper txMAPExt_ForwFeatureWrapper = (TxMAPExt_ForwFeatureWrapper)mAPExt_ForwFeatureWrapper;
    		ExtForwFeature txExtForwFeature = txMAPExt_ForwFeatureWrapper.getTxExtForwFeature();
    		ExtForwFeature extForwFeature = mapParameterFactory.createExtForwFeature(
    				txExtForwFeature.getBasicService(),
    				txExtForwFeature.getSsStatus(),
    				txExtForwFeature.getForwardedToNumber(),
    				txExtForwFeature.getForwardedToSubaddress(),
    				txExtForwFeature.getForwardingOptions(), 
    				txExtForwFeature.getNoReplyConditionTime(),
    				txExtForwFeature.getExtensionContainer(),
    				txExtForwFeature.getLongForwardedToNumber());
	    	return new TxMAPForwardingFeatureWrapper(extForwFeature);
    	}
    	return null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createMAPCallForwardingDataWrapper(pl.ovoo.jslee.ss7.wrapper.map.args.MAPExt_ForwFeatureWrapper[])
     */
    @Override
    public MAPCallForwardingDataWrapper createMAPCallForwardingDataWrapper(MAPExt_ForwFeatureWrapper[] mAPExt_ForwFeatureWrappers){
    	if(mAPExt_ForwFeatureWrappers == null){
    		return null;
    	}
    	/*final ArrayList<ExtForwFeature> txExtForwFeatures = new ArrayList<ExtForwFeature>();
    	if(mAPExt_ForwFeatureWrappers != null){
    		for(MAPExt_ForwFeatureWrapper mAPExt_ForwFeatureWrapper : mAPExt_ForwFeatureWrappers){
    			txExtForwFeatures.add(((TxMAPExt_ForwFeatureWrapper)mAPExt_ForwFeatureWrapper).getTxExtForwFeature());
    		}
    	}*/
    	return new TxMAPCallForwardingDataWrapper(mAPExt_ForwFeatureWrappers);
    	//TODO upgrade to newer version of restcomm map-api
    	//final CallForwardingData callForwardingData = new CallmapParameterFactory.createCallForwardingData(List<ExtForwFeature>);
    	/*CallForwardingData callForwardingData = new CallForwardingData() {
			
			@Override
			public boolean getNotificationToCSE() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public ArrayList<ExtForwFeature> getForwardingFeatureList() {
				// TODO Auto-generated method stub
				return txExtForwFeatures;
			}
			
			@Override
			public MAPExtensionContainer getExtensionContainer() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return new TxMAPCallForwardingDataWrapper(callForwardingData);*/
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#cloneMAPCallForwardingDataWrapper(pl.ovoo.jslee.ss7.wrapper.map.args.MAPCallForwardingDataWrapper)
     */
    @Override
    public MAPCallForwardingDataWrapper cloneMAPCallForwardingDataWrapper(MAPCallForwardingDataWrapper mAPCallForwardingDataWrapper){
    	if(mAPCallForwardingDataWrapper.getForwardingFeatureList() != null){
    		MAPExt_ForwFeatureWrapper[] mAPExt_ForwFeatureWrappers = mAPCallForwardingDataWrapper.getForwardingFeatureList();
    		MAPExt_ForwFeatureWrapper[] newExtForwFeatureWrappers = new MAPExt_ForwFeatureWrapper[mAPExt_ForwFeatureWrappers.length];
	    	for(int i=0; i<mAPExt_ForwFeatureWrappers.length; i++){
	    		TxMAPExt_ForwFeatureWrapper txMAPExt_ForwFeatureWrapper = (TxMAPExt_ForwFeatureWrapper)mAPExt_ForwFeatureWrappers[i];
	    		ExtForwFeature extForwFeature = txMAPExt_ForwFeatureWrapper.getTxExtForwFeature();
	    		
	    		ExtTeleserviceCode extTeleserviceCode = mapParameterFactory.createExtTeleserviceCode(extForwFeature.getBasicService().getExtTeleservice().getData());
	    		ExtBasicServiceCode basicServiceCode = mapParameterFactory.createExtBasicServiceCode(extTeleserviceCode);
	    		ExtSSStatus extSSStatus = mapParameterFactory.createExtSSStatus(extForwFeature.getSsStatus().getData());
	    		ISDNAddressString forwardedToNumber = mapParameterFactory.createISDNAddressString(
	    				AddressNature.getInstance(extForwFeature.getForwardedToNumber().getAddressNature().getIndicator()), 
	    				NumberingPlan.getInstance(extForwFeature.getForwardedToNumber().getNumberingPlan().getIndicator()), 
	    				extForwFeature.getForwardedToNumber().getAddress());
	    		ExtForwOptions extForwOptions = mapParameterFactory.createExtForwOptions(extForwFeature.getForwardingOptions().getData());
	    				
	    		ExtForwFeature newExtForwFeature = mapParameterFactory.createExtForwFeature(
	    				basicServiceCode, 
	    				extSSStatus, 
	    				forwardedToNumber, 
	    				null, 
	    				extForwOptions, 
	    				null, 
	    				null, 
	    				null);
	    		newExtForwFeatureWrappers[i] = new TxMAPExt_ForwFeatureWrapper(newExtForwFeature);
	    	}	
	    	return new TxMAPCallForwardingDataWrapper(newExtForwFeatureWrappers);
    	}
    	return null;
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createMAPExt_ForwFeatureWrapper(pl.ovoo.jslee.ss7.wrapper.map.args.MAPExt_BasicServiceCodeWrapper, pl.ovoo.jslee.ss7.wrapper.map.args.MAPForwardingOptionsWrapper, pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper, byte[])
     */
    @Override
    public MAPExt_ForwFeatureWrapper createMAPExt_ForwFeatureWrapper(
    		MAPExt_BasicServiceCodeWrapper mAPExt_BasicServiceCode, 
    		MAPForwardingOptionsWrapper forwardingOptions, 
    		AddressStringWrapper forwardedToNumber, 
    		byte[] cfStatus){
    	
    	ExtForwOptions txExtForwOptions = null;
    	if(forwardingOptions != null){
    		txExtForwOptions = ((TxMAPForwardingOptionsWrapper)forwardingOptions).getTxExtForwOptions();
   		}
    	ISDNAddressString txForwardedToNumber = null;
    	if(forwardedToNumber != null){
    		txForwardedToNumber = ((TxISDNAddressStringWrapperImpl)forwardedToNumber).getTxAddress();
   		}
    	ExtSSStatus extSSStatus = null;
    	if(cfStatus != null){
    		extSSStatus = mapParameterFactory.createExtSSStatus(cfStatus);
    	}
    	ExtBasicServiceCode basicServiceCode = null;
    	if(mAPExt_BasicServiceCode != null){
    		ExtTeleserviceCode extTeleserviceCode = mapParameterFactory.createExtTeleserviceCode(mAPExt_BasicServiceCode.getExt_Teleservice());
    		basicServiceCode = mapParameterFactory.createExtBasicServiceCode(extTeleserviceCode);
    	}
    	ExtForwFeature extForwFeature = mapParameterFactory.createExtForwFeature(
    			basicServiceCode, extSSStatus, txForwardedToNumber, null, 
    			txExtForwOptions, 
    			null, null, null);
    	return new TxMAPExt_ForwFeatureWrapper(extForwFeature);
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createMAPExt_BasicServiceCodeWrapper(byte[])
     */
    @Override
    public MAPExt_BasicServiceCodeWrapper createMAPExt_BasicServiceCodeWrapper(byte[] ext_Teleservice){
    	ExtTeleserviceCode extTeleserviceCode = mapParameterFactory.createExtTeleserviceCode(ext_Teleservice);
    	ExtBasicServiceCode basicServiceCode = mapParameterFactory.createExtBasicServiceCode(extTeleserviceCode);
    	return new TxMAPExt_BasicServiceCodeWrapper(basicServiceCode);
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createMAPForwardingOptionsWrapper(boolean, boolean, boolean, pl.ovoo.jslee.ss7.wrapper.map.args.ForwardingReason)
     */
    @Override
    public MAPForwardingOptionsWrapper createMAPForwardingOptionsWrapper(boolean notificationToForwardingParty, boolean redirectingPresentation, boolean notificationToCallingParty, ForwardingReason forwardingReason){
    	final ExtForwOptions extForwOptions = mapParameterFactory.createExtForwOptions(notificationToForwardingParty,
    			redirectingPresentation, notificationToCallingParty, ExtForwOptionsForwardingReason.getInstance(forwardingReason.getValue()));
    	return new TxMAPForwardingOptionsWrapper(extForwOptions);
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createMAPErrorWrapper()
     */
    @Override
    public MAPErrorWrapper createMAPErrorWrapper(){
    	MAPErrorMessage param = mapProvider.getMAPErrorMessageFactory().createMAPErrorMessageParameterless((long)1);
    	return new TxMAPErrorWrapper(param);
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createMAPUserAbortChoiceWrapper()
     */
    @Override
    public MAPUserAbortChoiceWrapper createMAPUserAbortChoiceWrapper(){
        MAPUserAbortChoice choice = mapParameterFactory.createMAPUserAbortChoice();
        choice.setUserSpecificReason();
    	return new TxMAPUserAbortChoiceWrapper(choice);
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createSendRoutingInfoRequestArgWrapper(pl.ovoo.jslee.ss7.wrapper.common.args.ISDNAddressStringWrapper, pl.ovoo.jslee.ss7.wrapper.common.args.ISDNAddressStringWrapper)
     */
    @Override
    public SendRoutingInfoRequestArgWrapper createSendRoutingInfoRequestArgWrapper(ISDNAddressStringWrapper msisdn, ISDNAddressStringWrapper gmscAddress){
        TxSendRoutingInfoRequestArgWrapper txSri = new TxSendRoutingInfoRequestArgWrapper();
        txSri.setMsisdn(msisdn);
        txSri.setGmscAddress(gmscAddress);
        return txSri;
        
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createSendRoutingInfoRequestForSMArgWrapper(pl.ovoo.jslee.ss7.wrapper.common.args.ISDNAddressStringWrapper, pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper)
     */
    @Override
	public SendRoutingInfoForSMRequestArgWrapper createSendRoutingInfoRequestForSMArgWrapper(ISDNAddressStringWrapper msisdn, AddressStringWrapper scAddress){
    	TxSendRoutingInfoForSMRequestArgWrapper txSriSm = new TxSendRoutingInfoForSMRequestArgWrapper();
    	txSriSm.setMsisdn(msisdn);
    	txSriSm.setScAddress(scAddress);
    	return txSriSm;
	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createMtForwardShortMessageRequestWrapper(java.lang.String, java.nio.charset.Charset, pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper, pl.ovoo.jslee.ss7.wrapper.common.args.IMSIAddressWrapper, java.lang.String, boolean, boolean, int, int, int)
	 */
	@Override
	public MtForwardShortMessageRequestWrapper createMtForwardShortMessageRequestWrapper(String text, Charset charset, AddressStringWrapper scOA, IMSIAddressWrapper imsi, String origAddress, boolean moreMessagesToSend,
			boolean isConcatened, int msgRef, int segmCnt, int segmNum){
		TxMtForwardShortMessageRequestArgWrapper txMtArg = new TxMtForwardShortMessageRequestArgWrapper();

		TxSmRpDaWrapper smRpDaWrapper = new TxSmRpDaWrapper();
		smRpDaWrapper.setIMSI(imsi);
		txMtArg.setSm_Rp_Da(smRpDaWrapper);

		TxSmRpOaWrapper smRpOaWrapper = new TxSmRpOaWrapper();
		smRpOaWrapper.setServiceCentreAddressOa(createIsdnAddressString(scOA.getNature(),scOA.getNumberingPlan(),scOA.getAddress()));
		txMtArg.setSm_Rp_Oa(smRpOaWrapper);

		TxSmRpUiWrapper smRpUiWrapper = new TxSmRpUiWrapper();
		smRpUiWrapper.setCharset(DataCodingWrapper.lookup(charset.name()));
		smRpUiWrapper.setText(text);
		smRpUiWrapper.setOriginatingAddress(origAddress);
		smRpUiWrapper.setMoreMessagesToSend(moreMessagesToSend);
		smRpUiWrapper.setIsConcatened(isConcatened);
		smRpUiWrapper.setMessageRef(msgRef);
		smRpUiWrapper.setSegmCnt(segmCnt);
		smRpUiWrapper.setSegmNum(segmNum);
		txMtArg.setSm_Rp_Ui(smRpUiWrapper);
		return txMtArg;
	}
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.MapArgsFactory#createMAPRequestedInfoWrapper(boolean, boolean, boolean)
     */
    @Override
    public MAPRequestedInfoWrapper createMAPRequestedInfoWrapper(boolean locationInformationPresent, boolean currentLocationPresent, boolean subscriberStatePresent){
    	RequestedInfo requestedInfo = getMapParameterFactory().createRequestedInfo(locationInformationPresent, subscriberStatePresent, null, currentLocationPresent, null, false, false, false);
    	return new TxMAPRequestedInfoWrapper(requestedInfo);
    }

	/**
	 * Gets the map provider.
	 *
	 * @return the map provider
	 */
	public MAPProvider getMapProvider() {
		return mapProvider;
	}

	/**
	 * Gets the map parameter factory.
	 *
	 * @return the map parameter factory
	 */
	public MAPParameterFactory getMapParameterFactory() {
		return mapParameterFactory;
	}

	/**
	 * Gets the map context interface factory.
	 *
	 * @return the map context interface factory
	 */
	public MAPContextInterfaceFactory getMapContextInterfaceFactory() {
		return mapContextInterfaceFactory;
	}
	
	
}
